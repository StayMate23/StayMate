package com.example.stay_mate.service.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import com.example.stay_mate.repository.hotel.FacilitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilitiesService {
    public final FacilitiesRepository facilitiesRepository;

    public FacilitiesService(FacilitiesRepository facilitiesRepository) {
        this.facilitiesRepository = facilitiesRepository;
    }
    public List<Facilities> getAllFacilities() {
        return facilitiesRepository.findAll();
    }
}
