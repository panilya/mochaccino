package com.panilya.mochaccinoserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoSuchFieldException.class, NoSuchElementException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> handleAllNoSuchFieldAndElementException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(exception.getMessage());
    }

    @ExceptionHandler(NotImplementedException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ResponseEntity<Object> handleNotImplementedException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body(exception.getMessage());
    }

    @ExceptionHandler(IncorrectFormatException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Object> handleIncorrectFormatException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(exception.getMessage());
    }
}
