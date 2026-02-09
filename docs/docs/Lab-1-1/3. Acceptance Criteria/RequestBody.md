---
sidebar_position: 4
---

# @RequestBody for POST/PUT

```java
@PostMapping
public ApiResponse<CurrencyEntity> createCurrency(
        @RequestHeader("X-Client-Id") String clientId,
        @RequestBody CurrencyEntity currency
) {
    System.out.println("Request from client: " + clientId);

    CurrencyEntity saved = service.createCurrency(currency);
    return new ApiResponse<CurrencyEntity>(saved, 1);
}

@PutMapping("/{id}")
public ApiResponse<CurrencyEntity> updateCurrency(
        @PathVariable("id") Long id,
        @RequestBody CurrencyEntity currency
) {
    Optional<CurrencyEntity> entity = service.updateCurrency(id, currency);
    return entity.map(currencyEntity -> new ApiResponse<>(currencyEntity, 1)).orElseGet(() -> new ApiResponse<>(null, 0));
}
```
