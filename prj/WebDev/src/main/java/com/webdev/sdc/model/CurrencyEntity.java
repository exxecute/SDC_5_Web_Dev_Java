package com.webdev.sdc.model;

public class CurrencyEntity {
    private Long id;
    private String type;
    private double rate;

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
