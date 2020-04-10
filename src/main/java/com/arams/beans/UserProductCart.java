package com.arams.beans;
// Generated Apr 8, 2020, 8:15:09 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserProductCart generated by hbm2java
 */
@Entity
@Table(name="user_product_cart"
    ,catalog="ecommerce"
)
public class UserProductCart  implements java.io.Serializable {


     private UserProductCartId id;

     @JsonBackReference
     private Product product;

     @JsonBackReference
     private User user;

     private int quantity;

    public UserProductCart() {
    }

    public UserProductCart(UserProductCartId id, Product product, User user, int quantity) {
       this.id = id;
       this.product = product;
       this.user = user;
       this.quantity = quantity;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userId", column=@Column(name="user_id", nullable=false) ), 
        @AttributeOverride(name="productId", column=@Column(name="product_id", nullable=false) ) } )
    public UserProductCartId getId() {
        return this.id;
    }
    
    public void setId(UserProductCartId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


