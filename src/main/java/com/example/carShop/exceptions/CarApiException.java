package com.example.carShop.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CarApiException extends Exception {

    @Getter
    private HttpStatus httpStatus;

    public CarApiException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CarApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
