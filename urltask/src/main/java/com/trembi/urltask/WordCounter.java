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
 *
 * @author matet
 */
public class WordCounter {
    
    private HashMap<String, Integer> hashMap;
    private HashSet<String> skipWords;
    private ArrayList<Map.Entry> arrayList;
    
    /**
     * Initializes the fields.
     */
    public WordCounter() {
        clean();
    }
    
    /**
     * Resets the stored words, skippable words, list fields in the object.
     */
    public final void clean() {
        hashMap = new HashMap<>();
        skipWords = new HashSet<>();
        arrayList = new ArrayList<>();
    }
    
    public void add(String str) {
        String[] words = str.split("\\W+");
        for (String s : words) {
            if (hashMap.containsKey(s)) {
                Integer i = hashMap.get(s);
                hashMap.replace(s, i+1);
            } else if (!skipWords.contains(s)) {
                hashMap.put(s.toLowerCase(), 1);
            }
        }
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
     * Analyzes every word which is stored in the Map.
     */
    public void countBiggestWords() {
        
        arrayList.clear();
        Iterator it = hashMap.entrySet().iterator();
        
        while (it.hasNext()) {
            int i  = 0;
            int size = arrayList.size();
            Map.Entry pair = (Map.Entry) it.next();
            Integer value = (Integer) pair.getValue();

            while(i < size && (Integer) arrayList.get(i).getValue() > value) {
                i++;
            }
            arrayList.add(i, pair);
            it.remove();
            i++;
        }
        
    }
    
    /**
     * Prints at most n word, number pair in descending order by the number.
     * @param n 
     */
    public void printWords(int n) {
        
        int size = arrayList.size();
        
        for (int i = 0; i < n && i < size; i++) {
            System.out.println(arrayList.get(i).getKey() + " = " 
                    + arrayList.get(i).getValue());
        }
    }
   
}
