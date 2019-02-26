package com.agoda.hotel.service.impl;

import com.agoda.hotel.constants.RoomType;
import com.agoda.hotel.constants.SortingOrder;
import com.agoda.hotel.dao.Hotel;
import com.agoda.hotel.service.HotelService;
import com.agoda.hotel.dto.HotelDTO;
import com.agoda.hotel.repository.HotelRepository;
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
