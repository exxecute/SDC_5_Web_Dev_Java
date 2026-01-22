package com.webdev.sdc.controller;

import com.webdev.sdc.dto.CurrencyDto;
import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public CurrencyEntity getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurrencyEntity create(@Valid @RequestBody CurrencyDto currecyDto) {
        return service.create(currecyDto);
    }
}
