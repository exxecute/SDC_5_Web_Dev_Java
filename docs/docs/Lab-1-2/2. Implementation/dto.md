---
sidebar_position: 1
---

# DTO Validation

> 1. Add validation to input data for create and update operations

```java
public class CurrencyDto {

    @ValidCurrencyCode
    private String type;

    @Positive(message = "rate must be greater than 0")
    private double rate;

    public CurrencyDto() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
```
