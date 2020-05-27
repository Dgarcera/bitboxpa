package com.ultimate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="supplier")
@EntityListeners(AuditingEntityListener.class)
public class Supplier {
    
    @Id
    @Column
    @NotNull
    private Long supplierID;
    
    @Column
    @NotNull
    private String name;
    
    @Column
    @NotNull
    private String country;

    public Supplier() {
        
    }

    public Supplier(Long supplierID, String name, String country) {
        this.supplierID = supplierID;
        this.name = name;
        this.country = country;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
       
}
