package com.app.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties
public class Order implements Serializable{

    private static final long serialVersionUID = -5494736327517230860L;
    
    private int ID;
    
    @JsonProperty("consumerID")
    private int consumerID;
    
    public Order() {
    }
    
    public Order(int ID, int consumerID) {
        this.ID = ID;
        this.consumerID = consumerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(int consumerID) {
        this.consumerID = consumerID;
    }
    
    
}
