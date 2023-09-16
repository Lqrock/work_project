package com.temporary.workforce.management.error_controller;

import com.temporary.workforce.management.exception.ContentNotAllowedException;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice()
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(){
        return new ResponseEntity<>("There is no entity with this ID" , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<String> handleContentNotAllowed() {
        return new ResponseEntity<>("Wrong fields and values or wrong use of this method", HttpStatus.BAD_REQUEST);
    }
}
