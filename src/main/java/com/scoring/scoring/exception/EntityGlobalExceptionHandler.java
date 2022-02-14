package com.scoring.scoring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityIncorrectDate> handleException(Exception exception) {
        EntityIncorrectDate personIncorrectDate = new EntityIncorrectDate();
        personIncorrectDate.setInfo(exception.getMessage());
        return new ResponseEntity<>(personIncorrectDate, HttpStatus.BAD_REQUEST);
    }
}
