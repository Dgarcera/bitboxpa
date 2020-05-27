package com.ultimate.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ForeignKey;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="items")
@EntityListeners(AuditingEntityListener.class)

public class Item {
	
    @Id
    @Column
    @NotNull
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long itemID;

    @Column
    @ForeignKey(name="priceID")
    @NotNull
    private Long priceID;

    @Column
    @ForeignKey(name="supplierID")
    @NotNull
    private Long supplierID;
    
    @Column
    @ForeignKey(name="userID")
    private String userID;
    
    @Column
    @NotBlank
    private String description;
    
    @Column
    @NotNull
    private boolean state;

    @Column
    @NotNull
    //@Temporal(TemporalType.TIMESTAMP)
    private String created;

    public Item() {
        
    }

    public Item(Long itemID, Long priceID, Long supplierID, String userID, String description, boolean state, String created) {
        this.itemID = itemID;
        this.priceID = priceID;
        this.supplierID = supplierID;
        this.userID = userID;
        this.description = description;
        this.state = state;
        this.created = created;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Long getPriceID() {
        return priceID;
    }

    public void setPriceID(Long priceID) {
        this.priceID = priceID;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String createdAt) {
        this.created = createdAt;
    }
    
}