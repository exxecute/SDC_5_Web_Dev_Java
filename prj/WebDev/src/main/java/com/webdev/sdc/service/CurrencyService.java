package com.webdev.sdc.service;

import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public List<CurrencyEntity> getAll() {
        return repository.findAll();
    }

    public List<CurrencyEntity> getByType(String type) {
        return repository.findByType(type);
    }

    public Optional<CurrencyEntity> getCurrencyById(Long id) {
        return repository.findById(id);
    }

    public CurrencyEntity createCurrency(CurrencyEntity currency) {
        return repository.save(currency);
    }

    public Optional<CurrencyEntity> updateCurrency(Long id, CurrencyEntity currency) {
        return repository.findById(id).map(existing -> {
            CurrencyEntity updated = new CurrencyEntity(id, currency.getType(), currency.getRate());
            return repository.save(updated);
        });
    }

    public boolean deleteCurrency(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
