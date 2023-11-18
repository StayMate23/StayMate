package com.example.stay_mate.repository.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import com.example.stay_mate.model.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilitiesRepository  extends JpaRepository<Facilities,Integer> {
    List<Facilities> getFacilitiesByHotel(Hotel hotel);
}
