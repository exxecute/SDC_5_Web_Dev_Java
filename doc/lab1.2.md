# Lab 1: Part 2 — Validation and Error Handling

## Tasks

1. Add validation to input data for create and update operations. For example:
   - For currency: validate that currency code is 3 uppercase letters (`@Size`, `@Pattern`)
   - For rate: validate that rate is greater than 0 (`@Min`)
2. Create `@RestControllerAdvice` to handle validation errors and return user-friendly messages
3. Create at least 2 custom exceptions and handle them in the advice
4. Return 404 error when trying to delete a non-existent item
5. Return 409 (Conflict) error when trying to create an already existing item
6. Return 200 with empty list `[]` when no items are found
7. Add 50% random chance to throw a custom exception on delete operation
8. Handle this custom exception using `@ExceptionHandler` in the controller

## Deliverables

- Validated DTOs with Jakarta Validation annotations
- Custom exception classes
- `@RestControllerAdvice` for global error handling
- Consistent error response format

## Acceptance Criteria

- Invalid input returns 400 with clear error messages
- Custom exceptions are handled properly
- Error responses follow a consistent format
- Random delete exception is caught and handled

## Extra Tasks

- Use `@Validated` at controller level to validate `@PathVariable` and `@RequestParam`
- Create a custom validation annotation and apply it in requests

---

## Grading (10 points)

| Criteria | Points |
|----------|--------|
| Validation annotations on DTOs | 2 |
| @RestControllerAdvice works | 2 |
| Custom exceptions handled | 2 |
| Correct HTTP status codes returned | 1 |
| Consistent error response format | 1 |
| Code quality and organization | 2 |
| Extra tasks (bonus) | +2 |

## Materials
1. [Medium: Spring MVC Deep Dive](https://medium.com/@karan0361.be20/spring-mvc-427de39e8886)
2. [Baeldung: Spring @RequestParam](https://www.baeldung.com/spring-request-param)
3. [Baeldung: Spring @PathVariable](https://www.baeldung.com/spring-pathvariable)
4. [Baeldung: Jackson JSON Tutorial](https://www.baeldung.com/jackson)
5. [Baeldung: Custom Validator in Spring MVC](https://www.baeldung.com/spring-mvc-custom-validator)
6. [Baeldung: Validation in Spring MVC](https://www.baeldung.com/spring-mvc-custom-validator)
7. [Baeldung: Exception Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
8. [Spring Framework Validation Reference](https://docs.spring.io/spring-framework/reference/core/validation.html)

## Common Mistakes to Avoid

- **Confusing @PathVariable and @RequestParam** — path is part of URL, param is after `?`
- **Missing @RequestBody** — request body not deserialized, object fields are null
- **Jackson date formatting issues** — use `@JsonFormat` or configure ObjectMapper
- **Forgetting @Valid on @RequestBody** — validation won't trigger without it
- **Using @Valid instead of @Validated for groups** — `@Valid` doesn't support validation groups
- **Catching generic Exception** — handle specific exceptions, let others propagate
- **Exposing stack traces to clients** — security risk, use custom error responses

---

## Self-Check Questions
- What is the difference between `@PathVariable` and `@RequestParam`?
- When would you use `ResponseEntity` instead of returning an object directly?
- How does Jackson know which fields to serialize/deserialize?
- What annotation controls the date format in JSON output?
- What is the difference between `@Valid` and `@Validated`?
- How do you validate a field matches a specific regex pattern?
- What is `@ControllerAdvice` and when would you use it?
- How do you return different HTTP status codes for different exceptions?
- How do you create a custom validation annotation?
