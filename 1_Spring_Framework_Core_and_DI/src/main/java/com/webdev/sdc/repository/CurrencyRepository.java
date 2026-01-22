package com.webdev.sdc.repository;

import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;

import java.util.List;

public interface CurrencyRepository {
    double getRate(Currency currency);

    List<CurrencyEntity> findAll();

    CurrencyEntity findById(Long id);

    boolean existsByType(Currency type);

    CurrencyEntity save(CurrencyEntity currency);
//
//    void deleteById(Long id);
}
