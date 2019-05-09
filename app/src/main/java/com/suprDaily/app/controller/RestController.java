package com.suprDaily.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class RestController {

    @GetMapping("{city}")
    public ResponseEntity<List<String>> getAllHotels(
            @RequestHeader("api-key") String apiKey,
            @RequestParam(value = "sort", defaultValue = "ASC") String sortingOrder,
            @PathVariable("city") String city){



        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
