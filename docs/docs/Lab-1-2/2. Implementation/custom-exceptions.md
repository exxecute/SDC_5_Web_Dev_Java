---
sidebar_position: 3
---

# Custom Exceptions

> 3. Create at least 2 custom exceptions and handle them in the advice

```java title="Global"
public class GlobalException extends RuntimeException {
    public GlobalException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public String getName() {
        return "Global Exception";
    }
}
```

```java title="Not Found"
public class NotFoundException extends GlobalException{
    public NotFoundException(Long id, String message) {
        super(createMessage(id, message));
    }

    private static String createMessage(Long id, String message) {
        return "Not Found Exception with id " + id.toString();
    }

    @Override
    public String getName() {
        return "Not Found Exception";
    }
}
```

```java title="Conflict"
public class ConflictException extends GlobalException {
    public ConflictException(String message) {
        super(ConflictException.createMessage(message));
    }

    private static String createMessage(String message) {
        return "Conflict Exception: " + message;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }

    @Override
    public String getName() {
        return "Conflict Exception";
    }
}
```

```java title="Not Implemented"
public class NotImplementedException extends GlobalException {
    public NotImplementedException(String message) {
        super(createMessage(message));
    }

    private static String createMessage(String message) {
        return "Not Implemented: " + message;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_IMPLEMENTED;
    }

    @Override
    public String getName() {
        return "Not Implemented";
    }
}
```

```java title="Random"
public class RandomException extends GlobalException {
    public RandomException() {
        super("50/50 chance :) LOL");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.GATEWAY_TIMEOUT;
    }

    @Override
    public String getName() {
        return "Random Exception";
    }
}
```
