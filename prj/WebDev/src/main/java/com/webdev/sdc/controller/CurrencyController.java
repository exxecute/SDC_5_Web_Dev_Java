package com.webdev.sdc.controller;

import com.webdev.sdc.dto.CurrencyDto;
import com.webdev.sdc.model.ApiResponse;
import com.webdev.sdc.model.CurrencyEntity;
import com.webdev.sdc.service.CurrencyService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currency")
@Validated
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ApiResponse<CurrencyEntity> getCurrencyById(@PathVariable("id") Long id) {
        Optional<CurrencyEntity> entity = service.getCurrencyById(id);
        return entity.map(currencyEntity -> new ApiResponse<>(currencyEntity, 1)).orElseGet(() -> new ApiResponse<>(null, 0));
    }

    @GetMapping
    public ApiResponse<List<CurrencyEntity>> getCurrencies(@RequestParam(name = "type", required = false) String type) {
        List<CurrencyEntity> currencyEntities;

        if (type != null) {
            currencyEntities = service.getByType(type);
        } else {
            currencyEntities = service.getAll();
        }
        return new ApiResponse<>(currencyEntities, currencyEntities.size());
    }

    @PostMapping
    public ApiResponse<CurrencyEntity> createCurrency(
            @RequestHeader("X-Client-Id") String clientId,
            @Valid @RequestBody CurrencyDto currency
    ) {
        System.out.println("Request from client: " + clientId);

        CurrencyEntity saved = service.createCurrency(currency);
        return new ApiResponse<CurrencyEntity>(saved, 1);
    }

    @PutMapping("/{id}")
    public ApiResponse<CurrencyEntity> updateCurrency(
            @PathVariable("id") Long id,
            @Valid @RequestBody CurrencyDto currency
    ) {
        Optional<CurrencyEntity> entity = service.updateCurrency(id, currency);
        return entity.map(currencyEntity -> new ApiResponse<>(currencyEntity, 1)).orElseGet(() -> new ApiResponse<>(null, 0));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteCurrency(@PathVariable("id") Long id) {
        return new ApiResponse<Boolean>(service.deleteCurrency(id), 1);
    }
}