---
sidebar_position: 2
---

# Rest Controller Advice

> 2. Create `@RestControllerAdvice` to handle validation errors and return user-friendly messages

```java
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(GlobalException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus().value(),
                ex.getName(),
                List.of(ex.getMessage())
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
}
```
