package com.codechallange.socialnetapp.exception;

import com.codechallange.socialnetapp.error.Error;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class Exceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Error> handleDataIfNullPointerExceptionOccured() {
        Error error = new Error("No constraint", "There is no such record");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Error> handleDataIfEmptyResultAccessExceptionOccured(){
        Error error = new Error("No constraint", "There is no such record");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleDataIfIntegrityViolationExceptionOccured(){
        Error error = new Error("No constraint", "Cannot create record with the existing name");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(){
        Error error = new Error("No constraint", "Illegal argument exception");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
