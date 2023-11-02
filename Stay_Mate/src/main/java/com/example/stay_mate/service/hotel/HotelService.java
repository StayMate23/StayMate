package com.example.stay_mate.service.hotel;

import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.repository.hotel.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    public final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
