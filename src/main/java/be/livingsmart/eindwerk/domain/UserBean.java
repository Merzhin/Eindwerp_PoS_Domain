/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.livingsmart.eindwerk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Pieter
 */
@Entity
@Table
public class UserBean implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false)
    @NotNull(message = "{error.no.name}")
    @NotEmpty(message = "{error.no.name}")
    private String name;
    
    @JsonIgnore
    @Column(name = "hashedPassword", nullable = false)
    private String hashedPassword;
    
    @Column(name = "salt", nullable = false)
    private String salt;
    
    @JsonIgnore
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
        if (!plaintextPassword.matches("[0-9]+")) throw new IllegalArgumentException("Password can only contain numbers");
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
