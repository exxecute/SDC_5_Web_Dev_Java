---
sidebar_position: 1
---

# Get All

> - `GET /rates` (or `/items`) - list all items

```java
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
```

![get all example](./../../../../assets/Lab-1-1/get-all.png)
