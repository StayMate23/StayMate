package com.example.stay_mate.model.menubook;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.hotel.HotelBar;
import com.example.stay_mate.model.hotel.HotelRestaurant;
import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.model.restaurant.Restaurant;

public class MenuBook {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private Partner partner;
    private Restaurant restaurant;
    private Bar bar;
    private Hotel hotel;
    private HotelRestaurant hotelRestaurant;
    private HotelBar hotelBar;


}
