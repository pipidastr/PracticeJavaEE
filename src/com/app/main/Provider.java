package com.app.main;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties
public class Provider implements Serializable{

    private static final long serialVersionUID = -2994953547927924480L;
 
    private int ID;
    
    @JsonProperty("name")
    private String name;
    
    public Provider() {
    }

    public Provider(int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "provider ID = " + ID + " " + name;
    }
     
}