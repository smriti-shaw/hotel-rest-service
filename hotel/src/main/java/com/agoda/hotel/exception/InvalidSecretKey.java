package com.agoda.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSecretKey extends RuntimeException {

    public InvalidSecretKey(String msg) {
        super(msg);
    }
}
