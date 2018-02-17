/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import jdk.Exported;
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
public class ItemTest {
    
    Item newItem;
    
    public ItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        newItem = new Item();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void empty_Constructor_Test() 
    {
        assertEquals("Init",            newItem.getName());
        assertEquals(new BigDecimal(0), newItem.getPrice());
        assertEquals("",                newItem.getDescription());
    }
    
    @Test
    public void name_Price_Constructor_Succes_Test() 
    {
        Item beer = new Item("beer", new BigDecimal(1.99));
        assertEquals("beer",                beer.getName());
        assertEquals(new BigDecimal(1.99),  beer.getPrice());
        assertEquals("",                    beer.getDescription());
    }
    
    @Test
    public void name_Price_Description_Constructor_Succes_Test() 
    {
        Item stella = new Item("Stella", new BigDecimal(2.15), "Beer from Leuven");
        assertEquals("Stella",              stella.getName());
        assertEquals(new BigDecimal(2.15),  stella.getPrice());
        assertEquals("Beer from Leuven",    stella.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void name_Price_Constructor_Empty_Name_Fail_Test() 
    {
        new Item("", new BigDecimal(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void name_Price_Constructor_Null_Name_Fail_Test() 
    {
        new Item(null, new BigDecimal(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void name_Price_Constructor_Negative_Price_Fail_Test() 
    {
        new Item("Beer", new BigDecimal(-1));
    }
    
    @Test
    public void setPrice_0_EdgeCase_Succes_Test() 
    {
        newItem.setPrice(new BigDecimal(0));
        assertEquals(new BigDecimal(0), newItem.getPrice());
    }
    
    @Test
    public void setPrice_RandomInt_Succes_Test() 
    {
        newItem.setPrice(new BigDecimal(75));
        assertEquals(new BigDecimal(75), newItem.getPrice());
    }
    
    @Test
    public void setPrice_RandomDouble_Succes_Test() 
    {
        newItem.setPrice(new BigDecimal(75.286455));
        assertEquals(new BigDecimal(75.286455), newItem.getPrice());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setPrice_Negative_Price_Fail_Test() 
    {
        newItem.setPrice(new BigDecimal(-1));
    }
    
    @Test
    public void setName_Succes_Test()
    {
        newItem.setName("Beer");
        assertEquals("Beer", newItem.getName());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setName_Null_Fail_Test() 
    {
        newItem.setName(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setName_Empty_String_Fail_Test() 
    {
        newItem.setName("");
    }
    
    @Test
    public void setDescription_Succes_Test()
    {
        newItem.setDescription("");
        assertEquals("", newItem.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setDescription_Null_Fail_Test() 
    {
        newItem.setDescription(null);
    }
    
    @Test 
    public void equals_Fail_Test() 
    {
        Item testItem1 = new Item("Beer", new BigDecimal(2.00), "Beer from here");
        Item testItem2 = new Item("qsmdfj", new BigDecimal(2.00), "Beer from here");
        assertFalse(testItem1.equals(testItem2));
    }
    
    
    @Test 
    public void equals_Succes_Test() 
    {
        Item testItem1 = new Item("Beer", new BigDecimal(2.00), "Beer from here");
        Item testItem2 = new Item("qsmdfj", new BigDecimal(2.00), "Beer from here");
        testItem2.setName("Beer");
        assertTrue(testItem1.equals(testItem2));
    }
    
}
