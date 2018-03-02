/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.eindwerk.domain;

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
 *
 * @author PC
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

    
    
    public Long getShiftItemId() {
        return shiftItemId;
    }

    public void setShiftItemId(Long shiftItemId) {
        this.shiftItemId = shiftItemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

}