---
sidebar_position: 2
---

# Refactor service layer to use repository interfaces instead of DAO

```java
@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
```

```java
@Service
public class CurrencyService {
    private final CurrencyRepository repository;
    private final BankRepository bankRepository;

    public CurrencyService(CurrencyRepository repository, BankRepository bankRepository) {
        this.repository = repository;
        this.bankRepository = bankRepository;
    }
```