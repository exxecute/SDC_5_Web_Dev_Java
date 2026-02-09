package com.webdev.sdc.service;

import com.webdev.sdc.dto.CurrencyDto;
import com.webdev.sdc.exception.ConflictException;
import com.webdev.sdc.exception.NotFoundException;
import com.webdev.sdc.exception.RandomException;
import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;
    private Long id = 1L;

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

    public CurrencyEntity createCurrency(CurrencyDto currency) {
        if (repository.findByType(currency.getType()).isEmpty()) {
            return repository.save(this.entityFromDto(currency));
        } else {
            throw new ConflictException("Currency exists");
        }
    }

    public Optional<CurrencyEntity> updateCurrency(Long id, CurrencyDto currency) {
        return repository.findById(id).map(existing -> {
            CurrencyEntity updated = new CurrencyEntity(id, currency.getType(), currency.getRate());
            return repository.save(updated);
        });
    }

    public boolean deleteCurrency(Long id) {
        if (Math.random() < 0.5) {
            throw new RandomException();
        }
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        throw new NotFoundException(id, "Currency");
    }

    private CurrencyEntity entityFromDto(CurrencyDto dto) {
        return new CurrencyEntity(this.getIdAndIncrement(), dto.getType(), dto.getRate());
    }

    private Long getIdAndIncrement() {
        return this.id++;
    }
}
