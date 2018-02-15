/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import domain.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class DatabaseConnectionItem {
    

    EntityManager em;
    EntityManagerFactory emf;
    
    public DatabaseConnectionItem() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("be.living-smart.eindwerk_PoS_Domain_Persistence");
        em = emf.createEntityManager();
    }
    

    public void Demo () {
        
        
        Item item = new Item("stuff", new BigDecimal(1));

        
        DatabaseConnectionItem demo = new DatabaseConnectionItem();
        demo.persist(item);
        demo.deleteItem(item.getId());
        System.out.println("should be zero: " + getAllItems().size());
        demo.persist(item);
        System.out.println("should be one: " + getAllItems().size());
    }

    public void persist(Object object) 
    {     
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public List<Item> getAllItems() 
    {
        return em.createQuery("Select i from Item i", Item.class).getResultList(); 
        
    }
    
    public Item getItem (long id) {
        if(!em.getTransaction().isActive()) em.getTransaction().begin();
        Item item = em.find(Item.class, id);
        if (item == null) {
            throw new IllegalArgumentException("Item not found");
        } 
        return item;
    }
    
    public void deleteItem(long id) {
        
        try {
            if(!em.getTransaction().isActive()) em.getTransaction().begin();
            em.remove(getItem(id));
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.clear();
            e.printStackTrace();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        
    }
    
}
