package com.app.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties
public class Consumer implements Serializable{

    private static final long serialVersionUID = -1326514726591363183L;
    
    
    private int ID;
    
    @JsonProperty("name")
    private String name;

    public Consumer() {
    }

    public Consumer(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}