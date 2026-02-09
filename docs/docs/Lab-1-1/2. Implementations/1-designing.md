---
sidebar_position: 1
---

# 1. Designing

Have chosen application for processing currecies.

Chosen: `currency exchange rates`

Currency Entity Definition:
```java
public class CurrencyEntity {
    private final Long id;
    private final String type;
    private final double rate;

    public CurrencyEntity(Long id, String type, double rate) {
        this.id = id;
        this.type = type;
        this.rate = rate;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public double getRate() {
        return this.rate;
    }
}
```
