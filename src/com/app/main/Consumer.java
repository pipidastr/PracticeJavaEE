package com.app.main;

import java.io.Serializable;

public class Consumer implements Serializable{

    private static final long serialVersionUID = -1326514726591363183L;
    
    private int ID;

    public Consumer(int iD) {
        super();
        ID = iD;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }
   
}