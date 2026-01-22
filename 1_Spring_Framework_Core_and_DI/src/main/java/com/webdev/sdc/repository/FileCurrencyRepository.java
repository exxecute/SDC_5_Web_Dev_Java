package com.webdev.sdc.repository;

import com.webdev.sdc.exception.NotFoundException;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class FileCurrencyRepository implements CurrencyRepository {
    private final Map<Currency, Double> rates = new EnumMap<>(Currency.class);

    public FileCurrencyRepository(File file) {
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("Rates file not found: " + file.getAbsolutePath());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(line -> {
                String[] parts = line.split("=");
                rates.put(
                        Currency.valueOf(parts[0]),
                        Double.parseDouble(parts[1])
                );
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to read rates file: " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public double getRate(Currency currency) {
        return rates.getOrDefault(currency, 0.0);
    }

    @Override
    public List<CurrencyEntity> findAll() {
        return rates.entrySet()
                .stream()
                .map(entry -> new CurrencyEntity(
                        (long) (entry.getKey().ordinal() + 1),
                        entry.getKey(),
                        entry.getValue()
                ))
                .toList();
    }

    @Override
    public CurrencyEntity findById(Long id) {
        if (id == null || id < 1 || id > rates.size()) {
            throw new NotFoundException(id, "Currency");
        }

        int index = 0;

        for (Map.Entry<Currency, Double> entry : rates.entrySet()) {
            index++;
            if (index == id) {
                return new CurrencyEntity(
                        id,
                        entry.getKey(),
                        entry.getValue()
                );
            }
        }

        throw new NotFoundException(id, "Currency");
    }

    @Override
    public boolean existsByType(Currency type) {
        return findAll().stream()
                .anyMatch(c -> c.getType() == type);
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        if (currency == null) {
            throw new IllegalArgumentException("CurrencyEntity must not be null");
        }

        if (currency.getType() == null) {
            throw new IllegalArgumentException("Currency type must not be null");
        }

        if (rates.containsKey(currency.getType())) {
            rates.put(currency.getType(), currency.getRate());
            return currency;
        }

        rates.put(currency.getType(), currency.getRate());
        return findById((long) rates.size());
    }
}
