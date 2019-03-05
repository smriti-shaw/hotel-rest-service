package com.learnthetek.hotel.service;

import com.learnthetek.hotel.dto.RateLimitModel;
import org.springframework.stereotype.Component;

@Component
public interface RateLimitService {

    void createIpStoreMap();

    void updateIpStoreMap(RateLimitModel rateLimitModel);

    Boolean updateAndCheckEligibilityOfRequest(String apiKey);
}
