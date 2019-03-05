package com.learnthetek.hotel.service.impl;

import com.learnthetek.hotel.constants.RoomType;
import com.learnthetek.hotel.constants.SortingOrder;
import com.learnthetek.hotel.dao.Hotel;
import com.learnthetek.hotel.service.HotelService;
import com.learnthetek.hotel.dto.HotelDTO;
import com.learnthetek.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<HotelDTO> getHotelsByCityId(String city, String sort) {
        SortingOrder sortOrder = SortingOrder.ASC;
        if(sort.compareToIgnoreCase("desc") == 0)
            sortOrder = SortingOrder.DESC;

        return getHotelFromRepository(city, sortOrder);

    }
    private List<HotelDTO> getHotelFromRepository(String city, SortingOrder sort){
        List<Hotel> hotels = getHotels();

        List<HotelDTO>  hotelDTOS = hotels.stream().filter(hotel -> hotel.getCity().compareToIgnoreCase(city) == 0).sorted().map(
                h -> new HotelDTO(h.getCity() , h.getHotelId(), RoomType.getRoomType(h.getRoomType()) , h.getPrice())
        ).collect(Collectors.toList());

        if(SortingOrder.DESC == sort) {
            hotelDTOS = hotelDTOS.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
        return  hotelDTOS;
    }

    public List<Hotel> getHotels(){
        return hotelRepository.getAllHotels();
    }




}
