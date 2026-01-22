package com.webdev.sdc.model;

public class CurrencyEntity {
    private Long id;
    private Currency type;
    private double rate;

    public CurrencyEntity(Long id, Currency type, double rate) {
        this.id = id;
        this.type = type;
        this.rate = rate;
    }

    public Long getId() {
        return this.id;
    }

    public Currency getType() {
        return this.type;
    }

    public double getRate() {
        return this.rate;
    }
}
