package com.agoda.hotel.service;

import com.agoda.hotel.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

     List<HotelDTO> getHotelsByCityId(String city, String sort);
}
