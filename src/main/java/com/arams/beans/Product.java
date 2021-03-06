package com.arams.beans;
// Generated Apr 8, 2020, 8:15:09 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product"
        , catalog = "ecommerce"
)
public class Product implements java.io.Serializable {


    private Integer id;

    @JsonBackReference
    private Category category;

    private String name;
    private int price;
    private int quantity;
    private String description;


    @JsonManagedReference
    private Set<UserProductCart> userProductCarts = new HashSet<UserProductCart>(0);

    @JsonManagedReference
    private Set<ProductImage> productImages = new HashSet<ProductImage>(0);

    public Product() {
    }


    public Product(Category category, String name, int price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Category category, String name, int price, int quantity, Set<UserProductCart> userProductCarts, Set<ProductImage> productImages) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.userProductCarts = userProductCarts;
        this.productImages = productImages;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "price", nullable = false)
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,cascade=ALL, mappedBy = "product")
    public Set<UserProductCart> getUserProductCarts() {
        return this.userProductCarts;
    }

    public void setUserProductCarts(Set<UserProductCart> userProductCarts) {
        this.userProductCarts = userProductCarts;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public Set<ProductImage> getProductImages() {
        return this.productImages;
    }

    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public void addImage(ProductImage productImage) {
        if (productImages == null)
            productImages = new HashSet<>();
        productImage.setProduct(this);
        productImages.add(productImage);
    }


}


