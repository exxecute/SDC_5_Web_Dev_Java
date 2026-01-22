package com.webdev.sdc.service;

import com.webdev.sdc.dto.CurrencyDto;
import com.webdev.sdc.exception.ConflictException;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

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

        CurrencyEntity currecnyEntity = new CurrencyEntity(
                null,
                currencyDto.getType(),
                currencyDto.getRate()
        );

        return this.repository.save(currecnyEntity);
    }
}
