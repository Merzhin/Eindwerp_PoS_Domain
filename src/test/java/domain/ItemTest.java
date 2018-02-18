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

    }
//    
//    @Test
//    public void name_Price_Constructor_Succes_Test() 
//    {
//
//    }
//    
//    @Test
//    public void name_Price_Description_Constructor_Succes_Test() 
//    {
//
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void name_Price_Constructor_Empty_Name_Fail_Test() 
//    {
//        
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void name_Price_Constructor_Null_Name_Fail_Test() 
//    {
//        
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void name_Price_Constructor_Negative_Price_Fail_Test() 
//    {
//        
//    }
//    
//    @Test
//    public void setPrice_0_EdgeCase_Succes_Test() 
//    {
//        newItem.setPrice(new BigDecimal(0));
//        assertEquals(new BigDecimal(0), newItem.getPrice());
//    }
//    
//    @Test
//    public void setPrice_RandomInt_Succes_Test() 
//    {
//        newItem.setPrice(new BigDecimal(75));
//        assertEquals(new BigDecimal(75), newItem.getPrice());
//    }
//    
//    @Test
//    public void setPrice_RandomDouble_Succes_Test() 
//    {
//        newItem.setPrice(new BigDecimal(75.286455));
//        assertEquals(new BigDecimal(75.286455), newItem.getPrice());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void setPrice_Negative_Price_Fail_Test() 
//    {
//        newItem.setPrice(new BigDecimal(-1));
//    }
//    
//    @Test
//    public void setName_Succes_Test()
//    {
//        newItem.setName("Beer");
//        assertEquals("Beer", newItem.getName());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void setName_Null_Fail_Test() 
//    {
//        newItem.setName(null);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void setName_Empty_String_Fail_Test() 
//    {
//        newItem.setName("");
//    }
//    
//    @Test
//    public void setDescription_Succes_Test()
//    {
//        newItem.setDescription("");
//        assertEquals("", newItem.getDescription());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void setDescription_Null_Fail_Test() 
//    {
//        newItem.setDescription(null);
//    }
//    
//    @Test 
//    public void equals_Fail_Test() 
//    {
//
//    }
//    
//    public void equals_Fail_Test2() 
//    {
//
//    }
//    
//    public void equals_Fail_Test3() 
//    {
//
//    }
//    
//    @Test 
//    public void equals_Succes_Test() 
//    {
//
//    }
    
}
