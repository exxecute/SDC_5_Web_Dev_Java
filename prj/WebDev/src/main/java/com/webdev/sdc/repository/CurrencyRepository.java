package com.webdev.sdc.repository;

import com.webdev.sdc.model.CurrencyEntity;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository {
    List<CurrencyEntity> findAll();

    Optional<CurrencyEntity> findById(Long id);

    CurrencyEntity save(CurrencyEntity currency);

    void deleteById(Long id);

    List<CurrencyEntity> findByType(String type);
}
