package com.learnthetek.hotel.controller;

import com.learnthetek.hotel.constants.ErrorMsg;
import com.learnthetek.hotel.exception.InvalidAccesssKey;
import com.learnthetek.hotel.service.HotelService;
import com.learnthetek.hotel.dto.HotelDTO;
import com.learnthetek.hotel.exception.HotelException;
import com.learnthetek.hotel.repository.HotelRepository;
import com.learnthetek.hotel.service.RateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
                                                       @PathVariable("city") String city, HttpServletResponse response){

        if(response.getStatus() == ErrorMsg.INVALID_ACCESS_KEY_TOKEN)
            throw new InvalidAccesssKey(response.getHeader("error-response"));

        List<HotelDTO> hotels = hotelService.getHotelsByCityId(city, sortingOrder);
        if(hotels.isEmpty() )
            throw new HotelException(ErrorMsg.NO_HOTELS_AVAILABLE +city);

        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
