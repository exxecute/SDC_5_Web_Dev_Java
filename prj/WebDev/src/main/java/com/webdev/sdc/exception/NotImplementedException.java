package com.webdev.sdc.exception;

import org.springframework.http.HttpStatus;

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
