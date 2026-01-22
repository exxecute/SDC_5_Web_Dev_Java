package com.webdev.sdc.repository;

import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository {
    double getRate(Currency currency);

    List<CurrencyEntity> findAll();

//    Optional<Beverage> findById(Long id);
//
//    boolean existsByName(String name);
//
//    Beverage save(Beverage beverage);
//
//    void deleteById(Long id);
}
