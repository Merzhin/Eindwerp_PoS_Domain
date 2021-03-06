/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.hdr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *  {@link OrderBean} class, contains multiple ordered {@link Item}s. One {@link Shift} has multiple {@link OrderBean}s. Was named this way because Order was a keyword in JPA
 * @author Pieter
 */
@Entity
@Table
public class OrderBean implements Serializable 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy="order", fetch=FetchType.EAGER)
    @MapKey(name="id")
    private Map<Long, OrderedItem> OrderedItems;
    
    @ManyToOne
    @JsonIgnore
    private Shift shift;

    /**
     *  Returns the id that was generated by jpa
     * @return {@link Long} 
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id (gets generated by jpa)
     * @param id {@link Long}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *  Returns a  {@link Map}, the keys are the {@link Long} ids from the {@link OrderedItem}s
     * @return  {@link Map}
     */
    public Map<Long, OrderedItem> getOrderedItems() {
        return OrderedItems;
    }

    /**
     *  Sets the {@link OrderedItems} for this {@link OrderBean}
     * @param OrderedItems  {@link Map}
     */
    public void setOrderedItems(Map<Long, OrderedItem> OrderedItems) {
        this.OrderedItems = OrderedItems;
    }

    /** 
     *  Returns the {@link Shift} that this {@link OrderBean} belongs to
     * @return  Shift
     */
    public Shift getShift() {
        return shift;
    }

    /**
     *  Sets the  {@link Shift} that this {@link OrderBean} belongs to.
     * @param shift  {@link Shift}
     */
    public void setShift(Shift shift) {
        this.shift = shift;
    }
    
    
    

}
