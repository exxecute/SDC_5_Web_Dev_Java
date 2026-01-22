package com.webdev.sdc.exception;

import org.springframework.http.HttpStatus;

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
