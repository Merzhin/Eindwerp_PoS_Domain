/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.hdr;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 *  Currently this class is not in use. Could be implemented later if the owners want to keep track of stock
 * @author Pieter
 */
@Entity
@Table
public class Stock implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="stock")
    @MapKey(name="id")
    private Map<Long, StockItem> stock;
    
    public Map<Long, StockItem> getStock() {
        return stock;
    }

    public void setStock(Map<Long, StockItem> stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
