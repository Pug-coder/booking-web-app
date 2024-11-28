package com.example.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
public class BadNameException extends RuntimeException {
    private final String wrongFieldName;

    public BadNameException(String fieldName, String message) {
        super(message);
        this.wrongFieldName = fieldName;
    }
    public String getWrongFieldName() {
        return wrongFieldName;
    }
}
