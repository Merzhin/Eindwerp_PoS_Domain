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
 *  {@link UserBean} is a class that stores users, it stores a username, password (that gets salted and hashed) and keeps track of all the shifts that this user has supervised
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

    /**
     *  Returns {@link Long} id
     * @return  {@link Long}
     */
    public Long getId() {
        return id;
    }

    /**
     *  Sets the {@link Long} id for {@link UserBean}s. This is automatically generated in JPA.
     * @param id    {@link Long}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *  Returns the {@link String} username
     * @return  {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     *  Sets the {@link String} username. This is usually done by the be.livingsmart.eindwerk.UserController.
     * @param name  {@link String}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Returns the {@link String} hashedPassword. 
     * @return  {@link String} only containing numbers
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     *  Sets the {@link String} hashedPassword. If the password contains any characters other than numbers, the method will throw an {@link IllegalArgumentException}. 
     *  The plaintextPassword will be salted and hashed with BCrypt before setting it so no plaintext password gets stored.
     * @param plaintextPassword {@link String} Only containing numbers
     */
    public void setHashedPassword(String plaintextPassword) {
        if (!plaintextPassword.matches("[0-9]+")) throw new IllegalArgumentException("Password can only contain numbers");
        salt = BCrypt.gensalt(10);
        this.hashedPassword = BCrypt.hashpw(plaintextPassword, salt);
    }
    
    /**
     *  Returns true if the plaintextPassword alligns with hashedPassword in memory. Returns false if it doesn't.
     * @param plaintextPassword {@link String} plaintextPassword
     * @return  {@link Boolean}
     */
    public boolean validatePassword(String plaintextPassword) 
    {

        if(null == hashedPassword || !hashedPassword.startsWith("$2a$")) throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(plaintextPassword, hashedPassword);

    }

    /**
     *  Returns all {@link Shift}s this user has supervised.
     * @return  {@link Map}
     */
    public Map<Long, Shift> getShifts() {
        return shifts;
    }

    /**
     *  Sets {@link Map} for all {@link Shift}s this user has supervised
     * @param shifts    {@link Shift}s
     */
    public void setShifts(Map<Long, Shift> shifts) {
        this.shifts = shifts;
    }
    
    
    
}
