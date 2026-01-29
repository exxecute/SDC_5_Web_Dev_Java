package com.webdev.sdc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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
