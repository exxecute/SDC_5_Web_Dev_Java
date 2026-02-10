package com.webdev.sdc.repository;

import com.webdev.sdc.exception.NotImplementedException;
import com.webdev.sdc.model.CurrencyEntity;

import java.util.List;
import java.util.Optional;

public class JdbcCurrencyRepository implements CurrencyRepository{
    @Override
    public List<CurrencyEntity> findAll() {
        throw new NotImplementedException("Jdbc repository");
    }

    @Override
    public Optional<CurrencyEntity> findById(Long id) {
        throw new NotImplementedException("Jdbc repository");
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        throw new NotImplementedException("Jdbc repository");
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Jdbc repository");
    }

    @Override
    public List<CurrencyEntity> findByType(String type) {
        throw new NotImplementedException("Jdbc repository");
    }
}
