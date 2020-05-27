package com.ultimate.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Temporal;

@Entity
@Table(name="price reduction")
@EntityListeners(AuditingEntityListener.class)
public class Pricereduction {
    
    @Id
    @Column
    @NotNull
    private long priceID;
    
    @Column
    private double amount;
    
    @Column
    private String start;
    
    @Column
    private String end;

    public Pricereduction() {
        
    }
    
    public Pricereduction(long priceID, double amount, String startDate, String endDate) {
        this.priceID = priceID;
        this.amount = amount;
        this.start = startDate;
        this.end = endDate;
    }

    public long getPriceID() {
        return priceID;
    }

    public void setPriceID(long priceID) {
        this.priceID = priceID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return start;
    }

    public void setStartDate(String startDate) {
        this.start = startDate;
    }

    public String getEndDate() {
        return end;
    }

    public void setEndDate(String endDate) {
        this.end = endDate;
    }

}
