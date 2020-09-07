/* 
 * Main.java
 *
 * Copyright: SONY MUSIC ENTERTAINMENT 
 * Created on: Sep 01, 2020
 * Created by: Máté Trembickij
 */
package com.trembi.urltask;

import java.io.IOException;



/**
 *
 * @author matet
 */
public class Main { 
    
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UrlAnalyzer analyzer = new UrlAnalyzer();
        StringBuilder sb = new StringBuilder();
        String[] urlArray = {
            "https://people.inf.elte.hu/miszuu/", 
            "https://people.inf.elte.hu/miszuu/mykitties.html",
            "https://people.inf.elte.hu/miszuu/dogs.html"
        };
        
        analyzer.addSkipWord("a");
        analyzer.addSkipWord("dog");
        analyzer.addSkipWord("the");
        
        analyzer.addSkipTag("head");
        analyzer.addSkipTag("style");
        
        for (int i = 0, size = urlArray.length; i < size; i++) {
            try {
                analyzer.processUrl(urlArray[i]);
                sb.append(urlArray[i]);
                sb.append('\n');
            } catch (IOException e) {
                System.err.println("Error while loading a webpage, maybe wrong Url: " + e.getMessage());
            }
        }
        
        sb.append("The loaded webpages 10 most common words");
        System.out.println(sb.toString());
        analyzer.biggestWords(10);
    }
}
