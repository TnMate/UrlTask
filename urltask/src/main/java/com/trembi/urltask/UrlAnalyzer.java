/* 
 * UrlAnalyzer.java
 *
 * Copyright: SONY MUSIC ENTERTAINMENT 
 * Created on: Sep 01, 2020
 * Created by: Máté Trembickij
 */
package com.trembi.urltask;

import java.util.HashSet;
import java.util.LinkedList;
import java.net.*;
import java.io.*;

/**
 * 
 * @author matet
 */
public class UrlAnalyzer {
    
    private HashSet<String> skipTags;
    private LinkedList<HtmlObject> htmlList;
    private WordCounter counter;
    
    private String htmlString;
    
    /**
     * Constructor, sets the fields.
     */
    public UrlAnalyzer() {
        clean();
    }
    
    /**
     * Resets fields
     */
    private void clean() {
        skipTags = new HashSet<>();
        htmlList = new LinkedList<>();
        counter = new WordCounter();
        
        htmlString = null;
        
        skipTags.add("style");
        skipTags.add("head");
    }
    
    /**
     * 
     * @param url WebPage's url
     * @throws IOException Exception while reading the website.
     */
    public void processUrl(String url) throws IOException {
        clean();
        readUrl(url);
        processString();
    }
    
    public void biggestWords(int number) {
        counter.printWords(number);
    }
    
    /**
     * Analyzes the Website's HTML code
     */
    private void processString() {
        
        if (htmlString == null) {
            System.err.println("No String attached");
            return;
        }
        
        int size = htmlString.length();
        
        for (int i = 0; i < size; i++) {
            char c = htmlString.charAt(i);
            if (c == '<') { // Start of a tag
                for (int j = i+1; j < size; j++) {
                    if (htmlString.charAt(j) == '>') {
                        processTag(i+1,j-1);
                        i = j;
                        break;
                    }
                }
            } else if (c == ' ' || c == '\t') {
                // do nothing
            } else {
                for (int j = i; j < size - 1; j++) {
                    if (htmlString.charAt(j + 1) == '<') {
                        while (htmlString.charAt(j) == ' ' || 
                                htmlString.charAt(j) == '\t') {
                            j--;
                        }
                        processText(i,j);
                        i = j;
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Decides if a tag start or end tag and sets the name of it.
     * @param startIndex start of the tag
     * @param endIndex end of the tag
     */
    private void processTag(int startIndex, int endIndex) {        
        if (startIndex < 1 || endIndex < 1) {
            System.err.println("Wrong start or end index");
            return;
        }
        
        String nameOfTag;
        
        if (htmlString.charAt(startIndex) == '/') { 
            nameOfTag = getNameOfTag(startIndex + 1, endIndex); // End tag
            removeTag(nameOfTag);
        } else {
            nameOfTag = getNameOfTag(startIndex, endIndex); // Start tag
            addTag(nameOfTag);
        }
    }
    
    private String getNameOfTag(int startIndex, int endIndex) {        
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (htmlString.charAt(i) == ' ') {
                return htmlString.substring(startIndex, i);
            }
        }
        
        return htmlString.substring(startIndex, endIndex+1);
    }
    
    private void addTag(String type) {
        htmlList.addLast(new HtmlObject(HtmlObject.Type.TAG, type));
    }
    
    /**
     * This method removes the tag and processes the tags and texts between the start and end tag.
     * @param type type of the tag
     */
    private void removeTag(String type) {        
        HtmlObject ob = htmlList.getLast();
        boolean isSkip = skipTags.contains(type);
        
        while (!(ob.getType().equals(HtmlObject.Type.TAG) && ob.getvalue().equals(type))) {
            if (!isSkip && ob.getType().equals(HtmlObject.Type.TEXT)) {
                counter.addLine(ob.getvalue());
            }
            htmlList.removeLast();
            ob = htmlList.getLast();
        }
        
        htmlList.removeLast();

    }
    
    private void processText(int startIndex, int endIndex) {
        if (startIndex < 1 || endIndex < 1) {
            System.err.println("Wrong start or end index");
            return;
        }
        
        String value = htmlString.substring(startIndex, endIndex+1);
        htmlList.addLast(new HtmlObject(HtmlObject.Type.TEXT, value));
    }
    
    /**
     * Reads the website from the given url and loads into a field as String
     * @param url Website's url
     * @throws IOException 
     */
    private void readUrl(String url) throws IOException{
        URL site = new URL(url);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()))) {
            StringBuilder sb = new StringBuilder();

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close(); 

            htmlString = sb.toString();
        } 
    }
}
