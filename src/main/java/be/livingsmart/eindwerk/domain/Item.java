/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.eindwerk.domain;

import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    
    @Column(name = "price", nullable = false)
    private double price; 
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="logo", nullable=true)
    private Logo logo;
    
    @Column(name = "isFavorite", nullable = false)
    private boolean isFavorite;
    
    
    
    public Item (){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) 
    {
        if (id == null) throw new IllegalArgumentException("Id can't be null");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) 
    {
        if (name == null) throw new IllegalArgumentException("Name can't be empty");
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
    }
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Item)) return false;
        Item item = (Item) object;
        if (!this.name.equals(item.getName())) return false;
        if (!(this.price == item.getPrice())) return false;
        return true;
    }

    
    

    

    
}
