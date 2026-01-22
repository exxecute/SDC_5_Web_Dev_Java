package com.webdev.sdc.repository;

import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
                        (long) entry.getKey().ordinal(),
                        entry.getKey(),
                        entry.getValue()
                ))
                .toList();
    }
}
