---
sidebar_position: 5
---

# Extra

## Validated

```java
@RestController
@RequestMapping("/currency")
@Validated
public class CurrencyController {
    /* ... */
```

## Custom Validation

Create a custom validation annotation and apply it in requests

```java
@Documented
@Constraint(validatedBy = CurrencyCodeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCurrencyCode {

    String message() default "Invalid currency code. Must be 3 uppercase letters like USD, EUR";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
```

```java
public class CurrencyCodeValidator implements ConstraintValidator<ValidCurrencyCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false;

        return value.matches("[A-Z]{3}");
    }
}
```