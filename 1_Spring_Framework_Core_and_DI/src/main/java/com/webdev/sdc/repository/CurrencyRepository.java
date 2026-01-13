package com.webdev.sdc.repository;

import com.webdev.sdc.model.Currency;

public interface CurrencyRepository {
    double getRate(Currency currency);
}
