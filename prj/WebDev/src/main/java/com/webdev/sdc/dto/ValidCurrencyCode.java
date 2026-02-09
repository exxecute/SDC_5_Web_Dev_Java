package com.webdev.sdc.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CurrencyCodeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCurrencyCode {

    String message() default "Invalid currency code. Must be 3 uppercase letters like USD, EUR";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}