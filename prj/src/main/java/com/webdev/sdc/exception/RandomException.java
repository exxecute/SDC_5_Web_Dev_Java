package com.webdev.sdc.exception;

import org.springframework.http.HttpStatus;

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
