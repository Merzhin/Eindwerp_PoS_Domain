/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import be.livingsmart.hdr.Item;
import be.livingsmart.hdr.StockItem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class StockItemTest {
    StockItem stockItem; 
    Item item;
    
    @Before
    public void setUp() 
    {
        stockItem = new StockItem();
        item = new Item();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setItemFailsOnNull()
    {
        stockItem.setItem(null);
    }
    
    @Test
    public void setAmountSuccess()
    {
        stockItem.setAmount(75);
        assertEquals(75, stockItem.getAmount());
    }
    
    @Test
    public void setAmountEdgeCaseSuccess()
    {
        stockItem.setAmount(0);
        assertEquals(0, stockItem.getAmount());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setAmountNegativeAmountFails()
    {
        stockItem.setAmount(-15);
    }
    
    @Test
    public void incrementSuccess()
    {
        stockItem.increment(2);
        assertEquals(2, stockItem.getAmount());
    }
    
    
    @Test
    public void decrementSuccess()
    {
        stockItem.decrement(1);
        assertEquals(-1, stockItem.getAmount());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void incrementNegativeNumberFails()
    {
        stockItem.increment(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void decrementNegativeNumberFails()
    {
        stockItem.decrement(-1);
    }
    
    
    
}
