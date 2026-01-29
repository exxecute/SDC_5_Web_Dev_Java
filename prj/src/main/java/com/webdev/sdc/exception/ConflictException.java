package com.webdev.sdc.exception;

import org.springframework.http.HttpStatus;

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
