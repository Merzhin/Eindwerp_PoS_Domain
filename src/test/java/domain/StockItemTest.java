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
        item = new Item("Stella", new BigDecimal(2.15), "Beer from Leuven");
    }
    

    @Test
    public void empty_Constructor_Test() {

        assertEquals("Init",            stockItem.getItem().getName());
        assertEquals(new BigDecimal(0), stockItem.getItem().getPrice());
        assertEquals("",                stockItem.getItem().getDescription());
        assertTrue(new Item().equals(   stockItem.getItem()));
        assertEquals(0,                 stockItem.getAmount());
    }
    
    @Test
    public void item_Constructor_Succes_Test() 
    {
        stockItem = new StockItem(item);
        assertEquals("Stella",              stockItem.getItem().getName());
        assertEquals(new BigDecimal(2.15),  stockItem.getItem().getPrice());
        assertEquals("Beer from Leuven",    stockItem.getItem().getDescription());
        assertEquals(0,                     stockItem.getAmount());
        assertTrue(new Item("Stella", new BigDecimal(2.15), "Beer from Leuven").equals(       stockItem.getItem()));
    }
    
    @Test
    public void item_Amount_Constructor_Succes_Test() 
    {
        stockItem = new StockItem(item, 15);
        assertEquals("Stella",              stockItem.getItem().getName());
        assertEquals(new BigDecimal(2.15),  stockItem.getItem().getPrice());
        assertEquals("Beer from Leuven",    stockItem.getItem().getDescription());
        assertEquals(15,                    stockItem.getAmount());
        assertTrue(new Item("Stella", new BigDecimal(2.15), "Beer from Leuven").equals(       stockItem.getItem()));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void item_Constructor_Null_Fail_Test()
    {
        stockItem = new StockItem(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void item_amount_Constructor_Null_Fail_Test()
    {
        stockItem = new StockItem(null,0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void item_Constructor_Negative_Amount_Fail_Test()
    {
        stockItem = new StockItem(item,-1);
    }
    
    @Test
    public void setItem_Succes_Test()
    {
        stockItem.setItem(item);
        assertEquals(item, stockItem.getItem());
    }
    
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
        StockItem stockItem1 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 20);
        StockItem stockItem2 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 20);
        assertTrue(stockItem1.equals(stockItem2));
    }
    
    @Test
    public void equals_Fail_Test1() 
    {
        StockItem stockItem1 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 20);
        StockItem stockItem2 = new StockItem(new Item("Beer1", new BigDecimal(2.00), "Beer from here"), 20);
        assertFalse(stockItem1.equals(stockItem2));
    }
    
    @Test
    public void equals_Fail_Test2() 
    {
        StockItem stockItem1 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 20);
        StockItem stockItem2 = new StockItem(new Item("Beer", new BigDecimal(2.001), "Beer from here"), 20);
        assertFalse(stockItem1.equals(stockItem2));
    }
    
    @Test
    public void equals_Fail_Test3() 
    {
        StockItem stockItem1 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 20);
        StockItem stockItem2 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from hereeee"), 20);
        assertFalse(stockItem1.equals(stockItem2));
    }
    
    @Test
    public void equals_Fail_Test4() 
    {
        StockItem stockItem1 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 20);
        StockItem stockItem2 = new StockItem(new Item("Beer", new BigDecimal(2.00), "Beer from here"), 205);
        assertFalse(stockItem1.equals(stockItem2));
    }
    
    
    
    
}
