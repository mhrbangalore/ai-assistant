package com.mohan.ai_assistant.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AIException.class)
    public ResponseEntity<String> handleAI(AIException ex) {
        return ResponseEntity
                .internalServerError()
                .body(ex.getMessage());
    }
}
