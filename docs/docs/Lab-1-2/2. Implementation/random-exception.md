---
sidebar_position: 7
---

# Random Exception

> 7. Add 50% random chance to throw a custom exception on delete operation

```java title="Service"
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
```

![random exception](../../../assets/Lab-1-2/random-exception.png)
