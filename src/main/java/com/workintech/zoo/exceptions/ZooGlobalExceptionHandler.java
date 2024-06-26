package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ZooGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(ZooException exc) {
        ZooErrorResponse error = new ZooErrorResponse(
                exc.getMessage(),
                exc.getStatus().value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, exc.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(Exception exc) {
        ZooErrorResponse error = new ZooErrorResponse(
                exc.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
