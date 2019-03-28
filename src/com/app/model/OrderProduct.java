package com.app.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties
public class OrderProduct implements Serializable{
    
    private static final long serialVersionUID = 4583899138413083312L;
    
    private int ID;
    
    @JsonProperty("productID")
    private int productID;
    
    @JsonProperty("count")
    private int count;
    
    public OrderProduct() {
    }
    
    public OrderProduct(int ID, int productID, int count) {
        this.ID = ID;
        this.productID = productID;
        this.count =count;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
