/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Map;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

/**
 *
 * @author Pieter
 */
public class Order 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy="order")
    @MapKey(name="id")
    private Map<Long, OrderedItem> OrderedItems;
    
    @ManyToOne
    private Shift shift;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, OrderedItem> getOrderedItems() {
        return OrderedItems;
    }

    public void setOrderedItems(Map<Long, OrderedItem> OrderedItems) {
        this.OrderedItems = OrderedItems;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
    
    
    

}
