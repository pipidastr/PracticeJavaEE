package com.app.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties
public class Product implements Serializable{
    
    private static final long serialVersionUID = -1363689602281760557L;
    
    private int ID;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("providerID")
    private int providerID;
    
    @JsonProperty("price")
    private double price;
    
    @JsonProperty("count")
    private int count;
    
    public Product() {
    }
    
    public Product(int ID, String name, int providerID, double price, int count) {
        this.ID = ID;
        this.name = name;
        this.providerID = providerID;
        this.price = price;
        this.count = count;
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

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}