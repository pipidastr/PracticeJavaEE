package com.app.main;

public class OrderProduct {
    
    private int ID;
    private int productID;
    private int count;
    
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
