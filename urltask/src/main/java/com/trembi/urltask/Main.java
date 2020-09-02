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
        String[] urlArray = {"https://people.inf.elte.hu/miszuu/"};
        int size = urlArray.length;
        
        for (int i = 0; i < size; i++) {
            analyzer.processUrl(urlArray[i]);
        }
       
    }
}
