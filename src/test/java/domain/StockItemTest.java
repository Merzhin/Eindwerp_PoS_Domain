/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    

 

    /*
    @Test
    public void setItem_Succes_Test()
    {
        stockItem.setItem(item);
        
        assertEquals(item, stockItem.getItem());
    }*/
    
    @Test(expected = IllegalArgumentException.class)
    public void setItem_Null_Fail_Test()
    {
        stockItem.setItem(null);
    }
    
    @Test
    public void setAmount_Succes_Test()
    {
        stockItem.setAmount(75);
        assertEquals(75, stockItem.getAmount());
    }
    
    @Test
    public void setAmount_EdgeCase_Succes_Test()
    {
        stockItem.setAmount(0);
        assertEquals(0, stockItem.getAmount());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setAmount_Negative_Amount_Fail_Test()
    {
        stockItem.setAmount(-15);
    }
    
    @Test
    public void equals_Succes_Test() 
    {
        
    }
    
    @Test
    public void equals_Fail_Test1() 
    {
        
    }
    
    @Test
    public void equals_Fail_Test2() 
    {
        
    }
    
    @Test
    public void equals_Fail_Test3() 
    {
        
    }
    
    @Test
    public void equals_Fail_Test4() 
    {
        
    }
    
    @Test
    public void increment_Succes()
    {
        stockItem.increment(2);
        assertEquals(2, stockItem.getAmount());
    }
    
    
    @Test
    public void decrement_Succes()
    {
        stockItem.decrement(1);
        assertEquals(-1, stockItem.getAmount());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void increment_Negative_Number_Fail()
    {
        stockItem.increment(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void decrement_Negative_Number_Fail()
    {
        stockItem.decrement(-1);
    }
    
    
    
}
