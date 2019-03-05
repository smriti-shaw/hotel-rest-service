package com.learnthetek.hotel.controller;

import com.learnthetek.hotel.constants.SecretToken;
import com.learnthetek.hotel.dto.AccessKeyRequest;
import com.learnthetek.hotel.dto.RateLimitModel;
import com.learnthetek.hotel.exception.InvalidSecretKey;
import com.learnthetek.hotel.service.RateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/secure/token")
public class AccessController {

    @Autowired
    RateLimitService rateLimitService;

    @PostMapping
    public ResponseEntity<String> createApiKey(HttpServletRequest httpServletRequest, @RequestBody AccessKeyRequest accessKeyRequest){
        System.out.println(accessKeyRequest.getSecretToken());
        if(!accessKeyRequest.getSecretToken().equals(SecretToken.GET_API_SECRET_TOKEN.toString())){
            throw new InvalidSecretKey("secret token is invalid");
        }
        RateLimitModel rateLimitModel = new RateLimitModel(httpServletRequest.getRemoteAddr() , accessKeyRequest.getSecretToken());
        rateLimitService.updateIpStoreMap(rateLimitModel);
        return new ResponseEntity<>(rateLimitModel.getApiKey(), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<String> getDefaultApiKey(){
        RateLimitModel rateLimitModel = new RateLimitModel("0.0.0.0", "default");
        rateLimitService.updateIpStoreMap(rateLimitModel);
        return new ResponseEntity<>(rateLimitModel.getApiKey(), HttpStatus.ACCEPTED);

    }


}
