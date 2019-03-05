package com.learnthetek.hotel.repository;

import com.learnthetek.hotel.dao.Hotel;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public interface HotelRepository{

     List<Hotel> getAllHotels();

      BufferedReader initiateBufferReader() throws IOException;


}
