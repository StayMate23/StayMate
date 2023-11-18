package com.example.stay_mate.model.reservation;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.hotel.HotelBar;
import com.example.stay_mate.model.hotel.HotelRestaurant;
import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.model.restaurant.Restaurant;
import com.example.stay_mate.model.room.Room;
import com.example.stay_mate.model.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer userNumber;
    @ManyToOne
    private User user;
    @ManyToOne
    private Partner partner;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private HotelRestaurant hotelRestaurant;
    @ManyToOne
    private HotelBar hotelBar;
    @ManyToOne
    @JsonManagedReference
    private Room room;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Bar bar;

    public Reservation(Integer id, LocalDateTime startDate, LocalDateTime endDate, Integer userNumber, User user, Partner partner, Hotel hotel, HotelRestaurant hotelRestaurant, HotelBar hotelBar, Room room, Restaurant restaurant, Bar bar) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userNumber = userNumber;
        this.user = user;
        this.partner = partner;
        this.hotel = hotel;
        this.hotelRestaurant = hotelRestaurant;
        this.hotelBar = hotelBar;
        this.room = room;
        this.restaurant = restaurant;
        this.bar = bar;
    }

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public HotelRestaurant getHotelRestaurant() {
        return hotelRestaurant;
    }

    public void setHotelRestaurant(HotelRestaurant hotelRestaurant) {
        this.hotelRestaurant = hotelRestaurant;
    }

    public HotelBar getHotelBar() {
        return hotelBar;
    }

    public void setHotelBar(HotelBar hotelBar) {
        this.hotelBar = hotelBar;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
