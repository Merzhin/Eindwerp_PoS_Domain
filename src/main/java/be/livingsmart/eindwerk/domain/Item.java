/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.eindwerk.domain;

import ch.qos.logback.core.CoreConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private BigDecimal price; 
    
    @Column(name = "description", nullable = true)
    private String description;
    
    
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) 
    {
        if (!(price.compareTo(new BigDecimal(0)) >= 0)) throw new IllegalArgumentException("Price has to be higher than or equal to 0");
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) 
    {
        if (description == null) throw new IllegalArgumentException("Description can't be null");
        this.description = description;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Item)) return false;
        Item item = (Item) object;
        if (!this.name.equals(item.getName())) return false;
        if (!this.description.equals(item.getDescription())) return false;
        if (!this.price.equals(item.getPrice())) return false;
        return true;
    }
    
    

    

    
}
