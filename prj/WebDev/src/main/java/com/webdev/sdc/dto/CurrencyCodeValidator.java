package com.webdev.sdc.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CurrencyCodeValidator implements ConstraintValidator<ValidCurrencyCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false;

        return value.matches("[A-Z]{3}");
    }
}