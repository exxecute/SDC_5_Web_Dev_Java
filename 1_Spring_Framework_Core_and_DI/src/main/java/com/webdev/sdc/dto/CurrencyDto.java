package com.webdev.sdc.dto;

import com.webdev.sdc.model.Currency;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CurrencyDto {

    @NotNull(message = "type can't be null")
    private Currency type;

    @Positive(message = "rate must be greater than 0")
    private double rate;

    public CurrencyDto() { }

    public Currency getType() {
        return type;
    }

    public void setType(Currency type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
