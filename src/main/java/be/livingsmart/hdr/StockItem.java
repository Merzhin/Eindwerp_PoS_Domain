/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.hdr;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *  Currently this class is not in use. Could be implemented later if the owners want to keep track of stock
 * @author Pieter
 */
@Entity
@Table
public class StockItem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private Item item;
    
    @ManyToOne
    private Stock stock;
    
    @Column(name = "amount", nullable = false)
    private int amount;
            
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Item can't be null");
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount needs to be higher than or equal to 0");
        this.amount = amount;
    }    
    
    public void increment(int amount) 
    {
        if (amount < 0) throw new IllegalArgumentException("Amount has to be positive, please use the decrement function");
        this.amount += amount;
    }
    
    public void decrement(int amount)
    {
        if (amount < 0) throw new IllegalArgumentException("Amount has to be positive, please use the increment function");
        // TODO if (amount > this.amount), ask client how to handle
        this.amount -= amount;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    
            
            
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof StockItem))
        {
            return false;
        }
        else 
        {
            StockItem stockItem = (StockItem) object;
            if (this.amount == stockItem.getAmount() && this.item.equals(stockItem.getItem()))
            {
                return true;
            }
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
