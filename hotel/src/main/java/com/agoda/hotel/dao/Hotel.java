package com.agoda.hotel.dao;

import java.util.Objects;

public class Hotel implements Comparable<Hotel>{

    private String city;
    private Integer hotelId;
    private String roomType;
    private Double price;

    public Hotel(String city, Integer hotelId, String roomType, Double price) {
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

    public void setRoomType(String roomType) {
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
        Hotel hotel = (Hotel) o;
        return Objects.equals(city, hotel.city) &&
                Objects.equals(hotelId, hotel.hotelId) &&
                Objects.equals(roomType, hotel.roomType) &&
                Objects.equals(price, hotel.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, hotelId, roomType, price);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "city='" + city + '\'' +
                ", hotelId=" + hotelId +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Hotel h) {
        return price.compareTo(h.price);
    }
}
