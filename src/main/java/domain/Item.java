/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import ch.qos.logback.core.CoreConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author PC
 */
@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name;
    private BigDecimal price; 
    private String description;
    
    
    public Item ()
    {
        this("Init", new BigDecimal(0));
    }
    
    public Item (String name, BigDecimal price)
    {
        this(name, price, "");
    }
    
    public Item (String name, BigDecimal price, String description) 
    {
        setName(name);
        setPrice(price);
        setDescription(description);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) 
    {
        if (name == null || name.equals(""))
        {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) 
    {
        if (!(price.compareTo(new BigDecimal(0)) >= 0))
        {
            throw new IllegalArgumentException("Price has to be higher than or equal to 0");
        }
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) 
    {
        if (description == null)
        {
            throw new IllegalArgumentException("Description can't be null");
        }
        this.description = description;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Item))
        {
            return false;
        }
        else 
        {
            Item item = (Item) object;
            if (this.name.equals(item.getName()) && this.description.equals(item.getDescription()) && this.price.equals(item.getPrice())) 
            {
                return true;
            }
        }
        return false;
    }
    
    

    

    
}
