/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pieter
 */
@Entity
@Table
public class Shift 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "date", nullable = false)
    private Date date;
    
    @Column(name = "startTime", nullable = false)
    private Time startTime;
    
    @Column(name = "endTime", nullable = false)
    private Time endTime;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supervisor")
    private User supervisor; 
    
    @OneToMany(mappedBy="shift")
    @MapKey(name="id")
    private Map<Long, Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public Map<Long, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Long, Order> orders) {
        this.orders = orders;
    }

    
    
    
}
