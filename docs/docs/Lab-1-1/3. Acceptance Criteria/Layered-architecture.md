---
sidebar_position: 2
---

# Layered architecture

```java title="Controller"
@RestController
@RequestMapping("/currency")
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

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteCurrency(@PathVariable("id") Long id) {
        return new ApiResponse<Boolean>(service.deleteCurrency(id), 1);
    }
}
```

```java title="Service"
@Service
public class CurrencyService {
    private final CurrencyRepository repository;

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

    public CurrencyEntity createCurrency(CurrencyEntity currency) {
        return repository.save(currency);
    }

    public Optional<CurrencyEntity> updateCurrency(Long id, CurrencyEntity currency) {
        return repository.findById(id).map(existing -> {
            CurrencyEntity updated = new CurrencyEntity(id, currency.getType(), currency.getRate());
            return repository.save(updated);
        });
    }

    public boolean deleteCurrency(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
```

```java title="Repository"
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