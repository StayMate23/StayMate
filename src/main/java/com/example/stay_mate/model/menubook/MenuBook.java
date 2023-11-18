package com.example.stay_mate.model.menubook;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.hotel.HotelBar;
import com.example.stay_mate.model.hotel.HotelRestaurant;
import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.model.reservation.Reservation;
import com.example.stay_mate.model.restaurant.Restaurant;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_book")
public class MenuBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name = "description")
    private String description;
    @JoinColumn(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "bar_id")
    private Bar bar;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "hotel_restaurant_id")
    private HotelRestaurant hotelRestaurant;
    @ManyToOne
    @JoinColumn(name = "hotel_bar_id")
    private HotelBar hotelBar;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public MenuBook(Integer id, String name, String description,
                    double price, Partner partner, Restaurant restaurant,
                    Bar bar, Hotel hotel, HotelRestaurant hotelRestaurant,
                    HotelBar hotelBar, Reservation reservation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.partner = partner;
        this.restaurant = restaurant;
        this.bar = bar;
        this.hotel = hotel;
        this.hotelRestaurant = hotelRestaurant;
        this.hotelBar = hotelBar;
        this.reservation = reservation;
    }

    public MenuBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "MenuBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
