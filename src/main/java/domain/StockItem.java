/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author PC
 */
@Entity
public class StockItem implements Serializable {
    
    @Column
    private Item item;
    @Column
    private int amount;
    @Column
    private Long id;
    @Column
    private Stock stock;
    
    public StockItem(Item item, int amount)
    {
        setItem(item);
        setAmount(amount);
    }
    
    public StockItem(Item item) 
    {
        this(item, 0);
    }
    
    public StockItem()
    {
        this(new Item(), 0);
    }
            

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

    
    @ManyToOne
    @JoinColumn(name = "stock_id")
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    
    
    public void increment(int amount) 
    {
        if (amount < 0) throw new IllegalArgumentException("Amount has to be positive, please use the decrement function");
        this.amount += amount;
    }
    
    public void decrement(int amount)
    {
        if (amount < 0) throw new IllegalArgumentException("Amount has to be positive, please use the increment function");
        // TODO             if (amount > this.amount)               ask client how to handle
        this.amount -= amount;
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

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
