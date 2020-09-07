/* 
 * HtmlObject.java
 *
 * Copyright: SONY MUSIC ENTERTAINMENT 
 * Created on: Sep 02, 2020
 * Created by: Máté Trembickij
 */
package com.trembi.urltask;

/**
 * Stores data about an HTML Object's type and value.
 * @author matet
 */
public class HtmlObject {
    
    /**
     * A HTML Object's possible types.
     */
    enum Type {
        TAG,
        TEXT
    }
    
    private final Type type;
    private final String value;
    
    /**
     * Constructor.
     * @param type Enumerator which is the type of the HTML object.
     * @param value The value of the HTML object. Can be it's name or text depending on the object.
     */
    public HtmlObject(Type type, String value) {
        this.type = type;
        this.value = value;
    }
    
    public Type getType() {
        return type;
    }
    
    public String getvalue() {
        return value;
    }
}
