package com.example.stay_mate.model.hotel;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private double pricePerNight;
    @OneToMany(mappedBy = "hotel")
    private List<Facilities> facilitiesList;

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

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<Facilities> getFacilitiesList() {
        return facilitiesList;
    }

    public void setFacilitiesList(List<Facilities> facilitiesList) {
        this.facilitiesList = facilitiesList;
    }
}
