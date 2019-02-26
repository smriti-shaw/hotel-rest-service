package com.agoda.hotel.controller;

import com.agoda.hotel.service.HotelService;
import com.agoda.hotel.dto.HotelDTO;
import com.agoda.hotel.exception.HotelException;
import com.agoda.hotel.exception.RateLimitExceededException;
import com.agoda.hotel.repository.HotelRepository;
import com.agoda.hotel.service.RateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelOrderRestService {


@Autowired
HotelService hotelService;
@Autowired
RateLimitService rateLimitService;

@Autowired
    HotelRepository hotelRepository;

    @GetMapping("{city}")
    public ResponseEntity<List<HotelDTO>> getAllHotels(
                                                       @RequestHeader("api-key") String apiKey,
                                                       @RequestParam(value = "sort", defaultValue = "ASC") String sortingOrder,
                                                       @PathVariable("city") String city){

            Boolean isEligible = rateLimitService.updateAndCheckEligibilityOfRequest(apiKey);
            if(isEligible == Boolean.FALSE)
                throw  new RateLimitExceededException("oops!! you have exceeded request count. please try aftersometime ");
            List<HotelDTO> hotels = hotelService.getHotelsByCityId(city, sortingOrder);
            if(hotels.isEmpty() )
                throw new HotelException("currently no hotels are available for "+city);

        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
