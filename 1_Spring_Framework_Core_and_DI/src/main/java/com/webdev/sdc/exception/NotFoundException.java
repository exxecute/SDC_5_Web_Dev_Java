package com.webdev.sdc.exception;

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
