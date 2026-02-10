package com.webdev.sdc.repository;

import com.webdev.sdc.model.BankEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BankRepository {

    private final Map<Long, BankEntity> storage = new HashMap<>();
    private Long idCounter = 1L;

    public BankRepository() {
        this.save(new BankEntity("Swedbank"));
        this.save(new BankEntity("Revolut"));
    }

    public Optional<BankEntity> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public BankEntity save(BankEntity bank) {
        if (bank.getId() == null) {
            bank.setId(idCounter++);
        }
        storage.put(bank.getId(), bank);
        return bank;
    }

    public List<BankEntity> findAll() {
        return new ArrayList<>(storage.values());
    }
}
