package com.example.stay_mate.repository.hotel;

import com.example.stay_mate.model.hotel.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage,Integer> {
}
