/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Pieter
 */
public class User 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "hashedPassword", nullable = false)
    private String hashedPassword;
    
    @Column(name = "salt", nullable = false)
    private String salt;
    
    @OneToMany(mappedBy = "supervisor")
    private Map<Long, Shift> shifts;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String plaintextPassword) {
        salt = BCrypt.gensalt(10);
        this.hashedPassword = BCrypt.hashpw(plaintextPassword, salt);
    }
    
    public boolean validatePassword(String plaintextPassword) 
    {

        if(null == hashedPassword || !hashedPassword.startsWith("$2a$")) throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(plaintextPassword, hashedPassword);

    }

    public Map<Long, Shift> getShifts() {
        return shifts;
    }

    public void setShifts(Map<Long, Shift> shifts) {
        this.shifts = shifts;
    }
    
    
    
}
