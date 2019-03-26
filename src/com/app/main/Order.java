package com.app.main;

public class Order {

    private int ID;
    private int consumerID;
    
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
