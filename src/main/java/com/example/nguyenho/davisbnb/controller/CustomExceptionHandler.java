package com.example.nguyenho.davisbnb.controller;

import com.example.nguyenho.davisbnb.exception.UserNotAuthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({UserNotAuthorizedException.class})
    public ResponseEntity<?> handleUserNotFoundException(UserNotAuthorizedException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
