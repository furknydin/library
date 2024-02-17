package com.example.library.util;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ApiResponse implements Serializable {
    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
