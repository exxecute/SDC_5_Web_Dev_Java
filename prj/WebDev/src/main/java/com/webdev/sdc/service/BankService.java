package com.webdev.sdc.service;

import com.webdev.sdc.model.BankEntity;
import com.webdev.sdc.repository.BankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Transactional(readOnly = true)
    public List<BankEntity> getAll() {
        return bankRepository.findAllBanksOrderedByName();
    }
}
