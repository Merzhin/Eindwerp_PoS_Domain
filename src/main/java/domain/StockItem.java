/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author PC
 */
public class StockItem {
    
    Item item;
    int amount;
    
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
    
    
    
}
