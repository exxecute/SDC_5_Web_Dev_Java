package com.webdev.sdc.service;

import com.webdev.sdc.model.Currency;
import com.webdev.sdc.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public void printRate(Currency currency) {
        System.out.println(currency + " = " + repository.getRate(currency));
    }
}
