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
public class HtmlObject { // TODO MT: javadoc is missing. Reading only this class I don't know what is it for :)
    
    private final String type; // TODO MT: this should be an enum which has two constansts: TAG, TEXT
    private final String value;
    
    public HtmlObject(String type, String value) {// TODO MT: you left this "//" here, please delete it! :)
        this.type = type;
        this.value = value;
    }
    
    public String getType() {
        return type;
    }
    
    public String getvalue() {
        return value;
    }
    
    public void printHtmlObject() { // TODO MT: it is nicer to override toString() and I don't think this method is really necessary
        System.out.println(this);
    }

    @Override
    public String toString() {
        return type + ": " + value;
    }
    
}
