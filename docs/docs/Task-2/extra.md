---
sidebar_position: 5
---

# Extra

## Use a service layer to provide data to the controller

```java title="Service layer"
@Service
public class CurrencyService {
    private final CurrencyRepository repository;
    private Long id = 1L;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public List<CurrencyEntity> getAll() {
        return repository.findAll();
    }

    public List<CurrencyEntity> getByType(String type) {
        return repository.findByType(type);
    }

    public Optional<CurrencyEntity> getCurrencyById(Long id) {
        return repository.findById(id);
    }

    public CurrencyEntity createCurrency(CurrencyDto currency) {
        if (repository.findByType(currency.getType()).isEmpty()) {
            return repository.save(this.entityFromDto(currency));
        } else {
            throw new ConflictException("Currency exists");
        }
    }

    public Optional<CurrencyEntity> updateCurrency(Long id, CurrencyDto currency) {
        return repository.findById(id).map(existing -> {
            CurrencyEntity updated = new CurrencyEntity(id, currency.getType(), currency.getRate());
            return repository.save(updated);
        });
    }

    public boolean deleteCurrency(Long id) {
        if (Math.random() < 0.5) {
            throw new RandomException();
        }
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        throw new NotFoundException(id, "Currency");
    }

    private CurrencyEntity entityFromDto(CurrencyDto dto) {
        return new CurrencyEntity(this.getIdAndIncrement(), dto.getType(), dto.getRate());
    }

    private Long getIdAndIncrement() {
        return this.id++;
    }
}
```

## Serialize response to JSON

- ![1](../../assets/Lab-1-1/accept-endpoints/1.png)
- ![2](../../assets/Lab-1-1/accept-endpoints/2.png)
- ![3](../../assets/Lab-1-1/accept-endpoints/3.png)
- ![4](../../assets/Lab-1-1/accept-endpoints/4.png)
- ![5](../../assets/Lab-1-1/accept-endpoints/5.png)
- ![6](../../assets/Lab-1-1/accept-endpoints/6.png)
- ![7](../../assets/Lab-1-1/accept-endpoints/7.png)
- ![8](../../assets/Lab-1-1/accept-endpoints/8.png)
- ![9](../../assets/Lab-1-1/accept-endpoints/9.png)
- ![10](../../assets/Lab-1-1/accept-endpoints/10.png)
- ![11](../../assets/Lab-1-1/accept-endpoints/11.png)