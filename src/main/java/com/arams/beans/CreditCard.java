package com.arams.beans;
// Generated Apr 8, 2020, 8:15:09 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CreditCard generated by hbm2java
 */
@Entity
@Table(name="credit_card"
    ,catalog="ecommerce"
)
public class CreditCard  implements java.io.Serializable {


     private Integer code;
     private int limit;
     private byte used;

    public CreditCard() {
    }

    public CreditCard(int limit, byte used) {
       this.limit = limit;
       this.used = used;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="code", unique=true, nullable=false)
    public Integer getCode() {
        return this.code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }

    
    @Column(name="limit", nullable=false)
    public int getLimit() {
        return this.limit;
    }
    
    public void setLimit(int limit) {
        this.limit = limit;
    }

    
    @Column(name="used", nullable=false)
    public byte getUsed() {
        return this.used;
    }
    
    public void setUsed(byte used) {
        this.used = used;
    }




}


