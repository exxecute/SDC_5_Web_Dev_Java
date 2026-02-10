---
sidebar_position: 3
---

# Update Service

For example create

```java
public CurrencyEntity createCurrency(CurrencyDto currency) {
    if (bankRepository.findById(currency.getBankId()).isPresent()) {
        BankEntity bank = bankRepository.findById(currency.getBankId()).get();
        CurrencyEntity currencyEntity = this.entityFromDto(currency);
        if (bank.getCurrencies().contains(currencyEntity)) {
            throw new ConflictException("Currency exists");
        } else {
            List<CurrencyEntity> currencyEntities = bank.getCurrencies();
            currencyEntities.add(currencyEntity);
            bank.setCurrencies(currencyEntities);
            bankRepository.save(bank);
            return repository.save(currencyEntity);
        }
    } else {
        throw new NotFoundException(currency.getBankId(), "Bank");
    }
}
```
