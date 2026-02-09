---
sidebar_position: 3
---

# 3. Repository

```java title="interface"
public interface CurrencyRepository {
    List<CurrencyEntity> findAll();

    Optional<CurrencyEntity> findById(Long id);

    CurrencyEntity save(CurrencyEntity currency);

    void deleteById(Long id);

    List<CurrencyEntity> findByType(String type);
}
```

> 3. Use `List` or `Map` in the repository for data storage

```java title="Map Realisation"
@Repository
@Primary
public class MapCurrencyRepository implements CurrencyRepository{
    private final Map<Long, CurrencyEntity> currencyMap = new HashMap<>();
    private long currentId = 1;

    @Override
    public List<CurrencyEntity> findAll() {
        return new ArrayList<>(currencyMap.values());
    }

    @Override
    public Optional<CurrencyEntity> findById(Long id) {
        return Optional.ofNullable(currencyMap.get(id));
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        if (currency.getId() == null) {
            currency = new CurrencyEntity(currentId++, currency.getType(), currency.getRate());
        }
        currencyMap.put(currency.getId(), currency);
        return currency;
    }

    @Override
    public void deleteById(Long id) {
        currencyMap.remove(id);
    }

    @Override
    public List<CurrencyEntity> findByType(String type) {
        List<CurrencyEntity> result = new ArrayList<>();
        for (CurrencyEntity c : currencyMap.values()) {
            if (c.getType().equalsIgnoreCase(type)) {
                result.add(c);
            }
        }
        return result;
    }
}
```
