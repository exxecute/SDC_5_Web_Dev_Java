---
sidebar_position: 6
---

# 6. @PathVariable

Used in almost all requests for id

```java
@GetMapping("/{id}")
public ApiResponse<CurrencyEntity> getCurrencyById(@PathVariable("id") Long id) {
    Optional<CurrencyEntity> entity = service.getCurrencyById(id);
    return entity.map(currencyEntity -> new ApiResponse<>(currencyEntity, 1)).orElseGet(() -> new ApiResponse<>(null, 0));
}

@PutMapping("/{id}")
public ApiResponse<CurrencyEntity> updateCurrency(
        @PathVariable("id") Long id,
        @RequestBody CurrencyEntity currency
) {
    Optional<CurrencyEntity> entity = service.updateCurrency(id, currency);
    return entity.map(currencyEntity -> new ApiResponse<>(currencyEntity, 1)).orElseGet(() -> new ApiResponse<>(null, 0));
}

@DeleteMapping("/{id}")
public ApiResponse<Boolean> deleteCurrency(@PathVariable("id") Long id) {
    return new ApiResponse<Boolean>(service.deleteCurrency(id), 1);
}
```

- [get one](../../../assets/Lab-1-1/get-one.png)
- [put](../../../assets/Lab-1-1/put.png)
- [delete](../../../assets/Lab-1-1/delete.png)
