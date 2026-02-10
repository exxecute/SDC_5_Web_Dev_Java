
# Apply @Transactional annotations to service methods where appropriate

```java
@Transactional(readOnly = true)
public List<BankEntity> getAll() 
```


```java
@Transactional(readOnly = true)
public List<CurrencyEntity> getAll()

@Transactional(readOnly = true)
public List<CurrencyEntity> getByType(String type)

@Transactional(readOnly = true)
public Optional<CurrencyEntity> getCurrencyById(Long id)

@Transactional()
public CurrencyEntity createCurrency(CurrencyDto currency)

@Transactional()
public Optional<CurrencyEntity> updateCurrency(Long id, CurrencyDto currency)

@Transactional()
public boolean deleteCurrency(Long id)
```
