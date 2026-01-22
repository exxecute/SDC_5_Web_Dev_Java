package com.webdev.sdc.exception;

public class ConflictException extends GlobalException {
    public ConflictException(String message) {
        super(ConflictException.createMessage(message));
    }

    private static String createMessage(String message) {
        return "Conflict Exception: " + message;
    }
}
