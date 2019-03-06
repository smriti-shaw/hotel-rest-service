package com.learnthetek.hotel.adapter;


import com.learnthetek.hotel.constants.ErrorMsg;
import com.learnthetek.hotel.exception.InvalidAccesssKey;
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
        String str = null;
        try {
            if (request.getRequestURI().contains("hotels"))
                isEligible = rateLimitService.updateAndCheckEligibilityOfRequest(apiKey);
        }catch (InvalidAccesssKey e){
            isEligible = Boolean.FALSE;
            str = e.getMessage();
        }catch (Exception e){
            isEligible = Boolean.FALSE;
            str = e.getMessage();
        }

         if(isEligible == Boolean.FALSE) {
             response.setStatus(ErrorMsg.INVALID_ACCESS_KEY_TOKEN);
             response.setHeader("error-response", str);
         }
        return super.preHandle(request, response, handler);
    }
}
