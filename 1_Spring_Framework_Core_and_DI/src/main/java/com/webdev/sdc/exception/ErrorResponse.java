package com.webdev.sdc.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private final String timestamp;
    private final int status;
    private final String error;
    private final List<String> details;

    public ErrorResponse(int status, String error, List<String> details) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.error = error;
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<String> getDetails() {
        return details;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
