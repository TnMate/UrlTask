/* 
 * HtmlObject.java
 *
 * Copyright: SONY MUSIC ENTERTAINMENT 
 * Created on: Sep 02, 2020
 * Created by: Máté Trembickij
 */
package com.trembi.urltask;

/**
 *
 * @author matet
 */
public class HtmlObject {
    
    private final String type;
    private final String value;
    
    public HtmlObject(String type, String value) {//
        this.type = type;
        this.value = value;
    }
    
    public String getType() {
        return type;
    }
    
    public String getvalue() {
        return value;
    }
    
    public void printHtmlObject() {
        System.out.println(type + ": " + value);
    }
    
}
