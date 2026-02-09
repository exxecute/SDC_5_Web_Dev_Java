---
sidebar_position: 5
---

# Extra tasks (bonus)

## Wrap responses in a response object with metadata (date, count)

Wrapping in controller

```java
public class ApiResponse<T> {
    private final LocalDateTime date;
    private final long count;
    private final T data;

    public ApiResponse(T data, long count) {
        this.date = LocalDateTime.now();
        this.count = count;
        this.data = data;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public long getCount() {
        return this.count;
    }

    public T getData() {
        return this.data;
    }
}
```

## Implement repository which works with any database (for example postgresql, h2)

Using interface of repository to creating repository by props

```java
public interface CurrencyRepository {
    List<CurrencyEntity> findAll();

    Optional<CurrencyEntity> findById(Long id);

    CurrencyEntity save(CurrencyEntity currency);

    void deleteById(Long id);

    List<CurrencyEntity> findByType(String type);
}
```
