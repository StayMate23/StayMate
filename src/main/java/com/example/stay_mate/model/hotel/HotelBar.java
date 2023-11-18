package com.example.stay_mate.model.hotel;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.model.partner.Partner;
import jakarta.persistence.*;

@Entity
@Table(name = "hotel_bar")
public class HotelBar  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public HotelBar(Integer id, String name, String description, Partner partner, Hotel hotel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.partner = partner;
        this.hotel = hotel;
    }

    public HotelBar() {
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

    @Override
    public String toString() {
        return "HotelBar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", partner=" + partner +
                ", hotel=" + hotel +
                '}';
    }
}
