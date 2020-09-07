/*
 * WordCounter.java
 *
 * Copyright: SONY MUSIC ENTERTAINMENT 
 * Created on: Sep 02, 2020
 * Created by: Máté Trembickij
 */
package com.trembi.urltask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * It counts the words which are added to this class.
 * @author matet
 */
public class WordCounter {
    
    /**
     * It contains the stored words with counts.
     */
    private final HashMap<String, Integer> wordsMap;
    
    /**
     * It contains which words to omit.
     */
    private final HashSet<String> skipWords;
    
    /**
     * Initializes the fields.
     */
    public WordCounter() {
        wordsMap = new HashMap<>();
        skipWords = new HashSet<>();
    }
    
    /**
     * Resets the stored words, omittable words, list fields in the object.
     */
    public final void clean() {
        wordsMap.clear();
        skipWords.clear();
    }
    
    /**
     * Separates the input into words and adds them if they are not omittable.
     * @param str Line to separate and add the words in it.
     */
    public void addLine(String str) {
        String[] words = str.split("\\W+");
        for (String s : words) { 
            addWord(s);
        }
    }
    
    /**
     * Adds a word into the map if it is not omittable.
     * @param s Word to be added.
     */
    public void addWord(String s) {
        s = s.toLowerCase();
        if ( skipWords.contains(s) )
            return;
            
        Integer i = wordsMap.get(s);
        wordsMap.put(s, i == null ? 1 : i+1);
    }
    
    /**
     * Updates the field parameter with the given word.
     * @param word Word which is not processed
     */
    public void addSkipWord(String word) {
        skipWords.add(word);
    }
    
    /**
     * Removes the word from the field parameter.
     * @param word 
     */
    public void removeSkipWord(String word) {
        skipWords.remove(word);
    }
    
    /**
     * Returns a sorted Array by value with every word which is stored in the Map.
     */
    private ArrayList<Map.Entry> sortMap(int n) {
        ArrayList<Map.Entry> words = new ArrayList();
        Iterator it = wordsMap.entrySet().iterator();
        int size = 0;
        
        while (it.hasNext()) {
            int i  = 0;
            size = size < n ? words.size() : n;
            Map.Entry pair = (Map.Entry) it.next();
            Integer value = (Integer) pair.getValue();

            while(i < size && (Integer) words.get(i).getValue() >= value) {
                i++;
            }
            words.add(i, pair);
            it.remove();
            i++;
        }
        
        return words;
    }
    
    /**
     * Prints at most n word, number pair in descending order by the number.
     * @param n 
     */
    public void printWords(int n) {
        ArrayList<Map.Entry> words = sortMap(n);
        
        for (int i = 0, size = words.size(); i < n && i < size; i++) {
            System.out.println(words.get(i).getKey() + " = " + words.get(i).getValue());
        }
    }
   
}
