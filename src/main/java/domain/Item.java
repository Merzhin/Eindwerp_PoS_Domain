/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author Pieter
 */
public class Item {
    private long _id;
    private String name;
    private BigDecimal price; 
    
    
    public Item (String name, BigDecimal price) 
    {
        setName(name);
        setPrice(price);
        generateID(); // In DB generation? 
    }
    
    public int generateID() 
    {
        //TODO
        return 0;
    } 
    
    
    public long getID() {
        return _id;
    }

    public void setID(long ID) {
        this._id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
