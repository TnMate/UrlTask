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
        String[] urlArray = {
            "https://people.inf.elte.hu/miszuu/", 
            "https://people.inf.elte.hu/miszuu/mykitties.html",
            "https://people.inf.elte.hu/miszuu/dogs.html"
        };
        
        for (int i = 0, size = urlArray.length; i < size; i++) {
            try {
                analyzer.processUrl(urlArray[i]);
                System.out.println(urlArray[i] + " webpage's 10 most common words:");
                analyzer.biggestWords(10);
            } catch (IOException e) {
                System.err.println("Error while loading a webpage, maybe wrong Url: " + e.getMessage());
            }
        }
    }
}
