package com.agoda.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAceesKey extends RuntimeException {

    public InvalidAceesKey(String msg){
        super(msg);
    }
}
