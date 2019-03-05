package com.learnthetek.hotel.dto;

import java.io.Serializable;
import java.util.Objects;

public class HotelDTO implements Serializable, Comparable<HotelDTO> {

    private String city;
    private Integer hotelId;
    private String roomType;
    private Double price;

    public HotelDTO(String city, Integer hotelId, String roomType, Double price) {
        this.city = city;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String  roomType) {
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDTO hotelDTO = (HotelDTO) o;
        return Objects.equals(city, hotelDTO.city) &&
                Objects.equals(hotelId, hotelDTO.hotelId) &&
                roomType == hotelDTO.roomType &&
                Objects.equals(price, hotelDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, hotelId, roomType, price);
    }

    @Override
    public int compareTo(HotelDTO h) {
        return price.compareTo(h.price);
    }
}
