package com.webdev.sdc.repository;

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
                String currency = String.valueOf(parts[0]);
                double rate = Double.parseDouble(parts[1]);

                rates.put(id, new CurrencyEntity(id, currency, rate));
                id++;
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read rates file: " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public List<CurrencyEntity> findAll() {
        return new ArrayList<>(rates.values());
    }

    @Override
    public Optional<CurrencyEntity> findById(Long id) {
        return Optional.ofNullable(rates.get(id));
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
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
        rates.remove(id);
    }

    @Override
    public List<CurrencyEntity> findByType(String type) {
        return List.of();
    }
}
