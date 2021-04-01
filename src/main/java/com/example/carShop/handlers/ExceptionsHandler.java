package com.example.carShop.handlers;

import com.example.carShop.exceptions.CarApiException;
import com.example.carShop.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@ControllerAdvice
@RestController
public class ExceptionsHandler {

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException error) {

        return new ResponseEntity<>(new ErrorResponse(error.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CarApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(CarApiException error) {

        return new ResponseEntity<>(new ErrorResponse(error.getMessage()), error.getHttpStatus());
    }
}
