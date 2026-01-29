package com.webdev.sdc.service;

import com.webdev.sdc.dto.CurrencyDto;
import com.webdev.sdc.exception.ConflictException;
import com.webdev.sdc.exception.GlobalException;
import com.webdev.sdc.exception.RandomException;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public void printRate(Currency currencyType) {
        System.out.println(currencyType + " = " + repository.getRate(currencyType));
    }

    public List<CurrencyEntity> getAll() {
        return repository.findAll();
    }

    public CurrencyEntity findById(Long id) {
        return repository.findById(id);
    }

    public CurrencyEntity create(CurrencyDto currencyDto) {
        if(repository.existsByType(currencyDto.getType())) {
            throw new ConflictException("Currency exists");
        }

        CurrencyEntity currencyEntity = new CurrencyEntity(
                null,
                currencyDto.getType(),
                currencyDto.getRate()
        );

        return this.repository.save(currencyEntity);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new GlobalException("id is null");
        }
        if (Math.random() < 0.5) {
            throw new RandomException();
        }
        repository.deleteById(id);
    }

    public CurrencyEntity update(Long id, @Valid CurrencyDto currencyDto) {
        if (id == null) {
            throw new GlobalException("id is null");
        }

        if (currencyDto == null) {
            throw new GlobalException("currencyDto is null");
        }

        CurrencyEntity currencyEntity = new CurrencyEntity(
                id,
                currencyDto.getType(),
                currencyDto.getRate()
        );

        return repository.save(currencyEntity);
    }
}
