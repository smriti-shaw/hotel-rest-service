package com.learnthetek.hotel;


import com.learnthetek.hotel.dao.Hotel;
import com.learnthetek.hotel.dto.HotelDTO;
import com.learnthetek.hotel.repository.HotelRepository;
import com.learnthetek.hotel.service.impl.HotelServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepositoryMock;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Test
    public void shouldReturnListOfHotel(){
        List<Hotel> hotels = new LinkedList<>();
        Hotel hotel1 = new Hotel("chennai", 1, "Delux", 1000.0  );
        Hotel hotel2 = new Hotel("bangkok", 2, "Delux", 100.0  );
        hotels.add(hotel1);
        hotels.add(hotel2);
        Mockito.when(hotelRepositoryMock.getAllHotels()).thenReturn(hotels);

        String city = "CHENNAI";
        String sort = "asc";
        List<HotelDTO> hotelDTOS = hotelService.getHotelsByCityId(city , sort);
        Assert.assertEquals("chennai", hotelDTOS.get(0).getCity());
    }

    @Test
    public void shouldNotReturnListOfHotel(){
        List<Hotel> hotels = new LinkedList<>();
        Hotel hotel1 = new Hotel("chennai", 1, "Delux", 1000.0  );
        Hotel hotel2 = new Hotel("bangkok", 2, "Delux", 100.0  );
        hotels.add(hotel1);
        hotels.add(hotel2);
        Mockito.when(hotelRepositoryMock.getAllHotels()).thenReturn(hotels);

        String city = "bafsgsgsg";
        String sort = "asc";
        List<HotelDTO> hotelDTOS = hotelService.getHotelsByCityId(city , sort);
        Assert.assertEquals(0 , hotelDTOS.size());
    }



}
