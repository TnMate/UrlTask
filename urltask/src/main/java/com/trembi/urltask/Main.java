/* 
 * Main.java
 *
 * Copyright: SONY MUSIC ENTERTAINMENT 
 * Created on: Sep 01, 2020
 * Created by: Máté Trembickij
 */
package com.trembi.urltask;



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
        String[] urlArray = {"https://people.inf.elte.hu/miszuu/", "https://people.inf.elte.hu/miszuu/mykitties.html","https://people.inf.elte.hu/miszuu/dogs.html"};
        int size = urlArray.length;
        
        for (int i = 0; i < size; i++) {
            analyzer.processUrl(urlArray[i]);
            System.out.println(urlArray[i] + " webpage's 10 most common words:");
            analyzer.biggestWords(10);
        }
       
    }
}
