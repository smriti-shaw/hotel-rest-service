package com.learnthetek.hotel.service;

import com.learnthetek.hotel.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

     List<HotelDTO> getHotelsByCityId(String city, String sort);
}
