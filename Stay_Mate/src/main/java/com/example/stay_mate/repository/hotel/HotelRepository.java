package com.example.stay_mate.repository.hotel;

import com.example.stay_mate.model.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
