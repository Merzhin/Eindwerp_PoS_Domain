/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.hdr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *  {@link ShiftItem} is linked to one {@link Item} and a {@link Shift}. It has an {@link Integer} (amount). This amount means how many {@link Item}s of this variety were sold during this {@link Shift}
 * @author Pieter
 */
@Entity
@Table
public class ShiftItem implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shiftItemId;
    
    @OneToOne
    private Item item;
    
    @ManyToOne
    @JsonIgnore
    private Shift shift;
    
    @Column(name = "amount", nullable = false)
    private int amount;

    /**
     *  Returns the {@link Long} id.
     * @return  {@link Long}
     */
    public Long getShiftItemId() {
        return shiftItemId;
    }

    /**
     *  Sets the {@link Long} id, this is generated automatically by JPA
     * @param shiftItemId   {@link Long}
     */
    public void setShiftItemId(Long shiftItemId) {
        this.shiftItemId = shiftItemId;
    }

    /**
     *  Returns the connected {@link Item}
     * @return  {@link Item}
     */
    public Item getItem() {
        return item;
    }

    /**
     *  Sets the connected {@link Item}, this is usually done by the be.livingsmart.eindwerk.OrderController
     * @param item  {@link Item}
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     *  Gets the {@link Integer} amount (This is the amount of {@link Item}s that are linked to this shift)
     * @return  {@link Integer}
     */
    public int getAmount() {
        return amount;
    }

    /**
     *  Sets the {@link Integer} amount (This is the amound of {@link Item}s that are linked to this shift). This is usually done by be.livingsmart.eindwerk.OrderController
     * @param amount    {@link Integer}
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     *  Returns the {@link Shift} object that this {@link ShiftItem} is connected to.
     * @return  {@link Shift}
     */
    public Shift getShift() {
        return shift;
    }

    /**
     *  Sets the {@link Shift} object that this {@link ShiftItem} is connected to. This is usually done by be.livingsmart.eindwerk.OrderController
     * @param shift {@link Shift}
     */
    public void setShift(Shift shift) {
        this.shift = shift;
    }

}