package com.learnthetek.hotel.adapter;

import com.learnthetek.hotel.exception.RateLimitExceededException;
import com.learnthetek.hotel.service.RateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class ApiKeyInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    RateLimitService rateLimitService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("i got called before you");

        String apiKey = request.getHeader("api-key");
        Boolean isEligible = Boolean.TRUE;

        if(!request.getRequestURI().contains("secure"))
        isEligible = rateLimitService.updateAndCheckEligibilityOfRequest(apiKey);
         if(isEligible == Boolean.FALSE)
            throw  new RateLimitExceededException("oops!! you have exceeded request count. please try aftersometime ");
        return super.preHandle(request, response, handler);
    }
}
