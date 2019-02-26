package com.agoda.hotel.repository.implementation;

import com.agoda.hotel.dao.Hotel;
import com.agoda.hotel.repository.HotelRepository;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class HotelRepositoryImpl implements HotelRepository
{
    private String fileName = "hoteldb.csv";
    private Path path = Paths.get(fileName);


    @Override
    public BufferedReader initiateBufferReader() throws IOException
    {
        return Files.newBufferedReader(path, StandardCharsets.US_ASCII);
    }

    @Override
    public List<Hotel> getAllHotels()
    {
        List<Hotel> hotels = new LinkedList<>();
        try{
            BufferedReader br = initiateBufferReader();
            Function<String, Hotel> hotelAdapter = (line) ->{
                String[] attributes = line.split(",");
                return new Hotel(attributes[0], Integer.parseInt(attributes[1]), attributes[2], Double.parseDouble(attributes[3]));
            };
            hotels = br.lines().skip(1).map(hotelAdapter).collect(Collectors.toList());
            System.out.println("hotels : "+hotels.size());
            br.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        return hotels;
    }

}
