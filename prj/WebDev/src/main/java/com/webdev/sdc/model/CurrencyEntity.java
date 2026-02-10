package com.webdev.sdc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class CurrencyEntity {
    @Id
    private Long id;
    private String type;
    private double rate;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;

    public CurrencyEntity() {    }

    public CurrencyEntity(Long id, String type, double rate) {
        this.id = id;
        this.type = type;
        this.rate = rate;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public double getRate() {
        return this.rate;
    }
}
