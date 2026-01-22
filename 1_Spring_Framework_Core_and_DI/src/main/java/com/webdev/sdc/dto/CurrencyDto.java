package com.webdev.sdc.dto;

import com.webdev.sdc.model.Currency;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CurrencyDto {
    @NotBlank(message = "can't be blank")
    private Currency type;
    @Min(value = 1, message = "must be greater")
    private double rate;

    public CurrencyDto() {

    }

    public Currency getType() {
        return this.type;
    }

    public void setType(Currency type) {
        this.type = type;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
