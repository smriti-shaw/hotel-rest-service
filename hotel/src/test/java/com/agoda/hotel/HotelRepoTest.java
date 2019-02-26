package com.agoda.hotel;

import com.agoda.hotel.dao.Hotel;
import com.agoda.hotel.repository.HotelRepository;
import com.agoda.hotel.repository.implementation.HotelRepositoryImpl;
import com.sun.tools.javac.util.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;



@SpringBootTest
public class HotelRepoTest {

    @Autowired
    HotelRepository hotelRepository;

    @Before
    public void setup (){
        FileWriter fileWriter = null;
        try{
             final String FILE_HEADER = "city,hotelId,roomType,price";
             fileWriter = new FileWriter("test.csv");
            String NEW_LINE_SEPARATOR = "\n";

            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("CHENNAI,1,delux,1000");


        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }

        }
    }

    @Test
    public void shouldReadFile() throws IOException {
         Path path = Paths.get("test.csv");

        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII);
        String cityId = "CHENNAI";
        HotelRepository hotelRepository = mock(HotelRepositoryImpl.class);
        when(hotelRepository.initiateBufferReader()).thenReturn(br);
        when(hotelRepository.getAllHotels()).thenCallRealMethod();
        List<Hotel> hotels =  hotelRepository.getAllHotels();
        assertEquals(cityId , hotels.get(0).getCity());

    }
}
