package com.webdev.sdc.dto;

import jakarta.validation.constraints.*;

public class CurrencyDto {

    @ValidCurrencyCode
    private String type;

    @Positive(message = "rate must be greater than 0")
    private double rate;

    private Long bankId;

    public CurrencyDto() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Long getBankId() {
        if (this.bankId == null) {
            return 0L;
        }
        return this.bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }
}
