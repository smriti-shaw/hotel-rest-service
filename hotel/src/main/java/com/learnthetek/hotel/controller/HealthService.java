package com.learnthetek.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthService {

    @GetMapping("/health")
    public String healthApi(){

        return "I am fine! You can proceed";
    }

}
