package com.arams.beans;
// Generated Apr 8, 2020, 8:15:09 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user"
        , catalog = "ecommerce"
        , uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User implements java.io.Serializable {


    private Integer id;
    private int creditLimit;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date birthDate;
    private byte admin;

    @JsonManagedReference
    private Set<UserProductCart> userProductCarts = new HashSet<>(0);

    public User() {
    }


    public User(int creditLimit, String imageName, String firstName, String lastName, String email, String password, byte admin) {
        this.creditLimit = creditLimit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public User(int creditLimit, String imageName, String firstName, String lastName, String email, String password, Date birthDate, byte admin, Set<UserProductCart> userProductCarts) {
        this.creditLimit = creditLimit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.admin = admin;
//       this.userProductCarts = userProductCarts;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)


    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "credit_limit", nullable = false)
    public int getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }


    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Column(name = "email", unique = true, nullable = false, length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", length = 10)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Column(name = "admin", nullable = false)
    public byte getAdmin() {
        return this.admin;
    }

    public void setAdmin(byte admin) {
        this.admin = admin;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserProductCart> getUserProductCarts() {
        return this.userProductCarts;
    }

    public void setUserProductCarts(Set<UserProductCart> userProductCarts) {
        this.userProductCarts = userProductCarts;
    }


}


