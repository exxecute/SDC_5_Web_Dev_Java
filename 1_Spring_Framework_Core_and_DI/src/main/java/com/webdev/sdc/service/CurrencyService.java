package com.webdev.sdc.service;

import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public void printRate(Currency currencyType) {
        System.out.println(currencyType + " = " + repository.getRate(currencyType));
    }

    public List<CurrencyEntity> getAll() {
        return repository.findAll();
    }
}
