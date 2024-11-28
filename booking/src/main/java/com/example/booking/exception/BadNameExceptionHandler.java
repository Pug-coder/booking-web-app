package com.example.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BadNameExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> response = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            response.put(error.getField(), error.getDefaultMessage()); // Возвращаем ошибку для каждого поля
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // Возвращаем ошибки с кодом 400
    }

    // Обработка кастомного исключения BadNameException
    @ExceptionHandler(BadNameException.class)
    public ResponseEntity<Map<String, String>> handleBadNameException(BadNameException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("field", ex.getWrongFieldName());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
