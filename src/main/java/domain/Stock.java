/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



/**
 *
 * @author PC
 */
@Entity
public class Stock implements Serializable{

    private Long id;
    Map<Long, StockItem> stock;
    
    
    @OneToMany(mappedBy = "StockItem", cascade = CascadeType.ALL)
    public Map<Long, StockItem> getStock() {
        return stock;
    }

    public void setStock(Map<Long, StockItem> stock) {
        this.stock = stock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
