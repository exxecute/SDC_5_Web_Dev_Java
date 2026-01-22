package com.webdev.sdc.controller;

import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<CurrencyEntity> getAll() {
        return service.getAll();
    }
}
