/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import be.livingsmart.hdr.Item;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class ItemTest {
    
    private Item newItem;    
    
    @Before
    public void setUp() 
    {
        newItem = new Item();
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
}
