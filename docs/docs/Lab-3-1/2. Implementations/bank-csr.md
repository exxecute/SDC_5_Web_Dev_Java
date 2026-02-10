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
