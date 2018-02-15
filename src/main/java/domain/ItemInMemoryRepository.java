/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Pieter
 */
public class ItemInMemoryRepository {
    
    private ArrayList<Item> itemRepository;

    public ItemInMemoryRepository () {
        itemRepository = new ArrayList<Item>();
    }
    
    
    public Item getItem (long ID)
    {
        
        for (Item item : itemRepository) 
        {
            if (item.getId() == ID) 
            {
                return item;
            }
        }
        
        return null;
    }
    public void addItem (Item item) 
    {
        itemRepository.add(item);
    }
    
    public void deleteItem (long ID) 
    {
        Item item = getItem(ID);
        itemRepository.remove(item);
    }
    
    public void updateItem (Item item) 
    {
        
        deleteItem(item.getId());
        addItem(item);
        
    }
    
    
}
