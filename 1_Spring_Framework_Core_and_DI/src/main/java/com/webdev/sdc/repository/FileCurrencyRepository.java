package com.webdev.sdc.repository;

import com.webdev.sdc.exception.NotFoundException;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class FileCurrencyRepository implements CurrencyRepository {
    private final Map<Long, CurrencyEntity> rates = new LinkedHashMap<>();

    public FileCurrencyRepository(File file) {
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("Rates file not found: " + file.getAbsolutePath());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            long id = 1;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                Currency currency = Currency.valueOf(parts[0]);
                double rate = Double.parseDouble(parts[1]);

                rates.put(id, new CurrencyEntity(id, currency, rate));
                id++;
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read rates file: " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public double getRate(Currency currency) {
        return rates.values().stream()
                .filter(e -> e.getType() == currency)
                .mapToDouble(CurrencyEntity::getRate)
                .findFirst()
                .orElse(0.0);
    }

    @Override
    public List<CurrencyEntity> findAll() {
        return new ArrayList<>(rates.values());
    }

    @Override
    public CurrencyEntity findById(Long id) {
        this.checkById(id);
        return rates.get(id);
    }

    @Override
    public boolean existsByType(Currency type) {
        return rates.values().stream()
                .anyMatch(e -> e.getType() == type);
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        if (currency == null) {
            throw new IllegalArgumentException("CurrencyEntity must not be null");
        }

        if (currency.getType() == null) {
            throw new IllegalArgumentException("Currency type must not be null");
        }

        Optional<Long> existingId = rates.entrySet().stream()
                .filter(entry -> entry.getValue().getType() == currency.getType())
                .map(Map.Entry::getKey)
                .findFirst();

        if (existingId.isPresent()) {
            Long id = existingId.get();
            rates.put(id, new CurrencyEntity(id, currency.getType(), currency.getRate()));
            return rates.get(id);
        }

        long newId = rates.isEmpty() ? 1 : Collections.max(rates.keySet()) + 1;
        CurrencyEntity newEntity = new CurrencyEntity(newId, currency.getType(), currency.getRate());
        rates.put(newId, newEntity);

        return newEntity;
    }

    @Override
    public void deleteById(Long id) {
        this.checkById(id);
        rates.remove(id);
    }

    private void checkById(Long id) {
        if (id == null || !rates.containsKey(id)) {
            throw new NotFoundException(id, "Currency");
        }
    }
}
