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
    
    private HashMap<String, Integer> hashMap; // TODO MT: please use a better variable name :)
    private HashSet<String> skipWords;
    private ArrayList<Map.Entry> arrayList; // TODO MT: please use a better variable name :)
    
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
    
    public void add(String str) { // TODO MT: I think here javadoc is really missing! I have to check the body of this method
        String[] words = str.split("\\W+");
        for (String s : words) {  // TODO MT: please check my version of this for loop body, don't use this type of for loop 
            if ( skipWords.contains(s) )
                continue;
            
            Integer i = hashMap.get(s);
            hashMap.put(s, i == null ? 1 : i+1);
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
    public void countBiggestWords() { // TODO MT: I don't like this method :) I will explain in person why
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
    public void printWords(int n) { // TODO MT: since variable 'size' is used only in the FOR  loop define it always as part of the FOR statement
        for (int i = 0, size = arrayList.size(); i < n && i < size; i++) {
            System.out.println(arrayList.get(i).getKey() + " = " + arrayList.get(i).getValue());
        }
    }
   
}
