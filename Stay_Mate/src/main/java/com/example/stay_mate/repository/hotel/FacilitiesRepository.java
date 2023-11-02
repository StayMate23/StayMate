package com.example.stay_mate.repository.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilitiesRepository  extends JpaRepository<Facilities,Integer> {
}
