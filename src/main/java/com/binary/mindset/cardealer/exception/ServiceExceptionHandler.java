package com.binary.mindset.cardealer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    public ResponseEntity<ErrorMessage> handleServiceException(ServiceException serviceException) {
        return ResponseEntity
                .status(serviceException.getHttpStatus())
                .body(buildErrorMessage(serviceException));
    }

    private ErrorMessage buildErrorMessage(ServiceException exception) {
        return new ErrorMessage.Builder()
                .withDescription(exception.getDescription())
                .withHttpStatus(exception.getHttpStatus())
                .build();
    }
}