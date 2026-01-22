package com.webdev.sdc.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id, String message) {
        super(createMessage(id, message));
    }

    private static String createMessage(Long id, String message) {
        return "Not Found Exception with id " + id.toString();
    }
}
