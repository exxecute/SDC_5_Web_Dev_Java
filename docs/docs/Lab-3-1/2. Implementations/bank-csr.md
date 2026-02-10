---
sidebar_position: 2
---

# Bank Controller Service Repository

Controller and Service for test

```java
@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<BankEntity>> getBanks() {
        List<BankEntity> entities = service.getAll();
        return new ApiResponse<>(entities, entities.size());
    }
}
```

```java
@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<BankEntity> getAll() {
        return bankRepository.findAll();
    }
}
```

```java
@Repository
public class BankRepository {

    private final Map<Long, BankEntity> storage = new HashMap<>();
    private Long idCounter = 1L;

    public BankRepository() {
        BankEntity None = new BankEntity("None");
        storage.put(None.getId(), None);
        this.save(new BankEntity("Swedbank"));
    }

    public Optional<BankEntity> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public BankEntity save(BankEntity bank) {
        if (bank.getId() == null) {
            bank.setId(idCounter++);
        }
        storage.put(bank.getId(), bank);
        return bank;
    }

    public List<BankEntity> findAll() {
        return new ArrayList<>(storage.values());
    }
}
```
