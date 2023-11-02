package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.service.hotel.FacilitiesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class FacilitiesController {

    private final FacilitiesService facilitiesService;

    public FacilitiesController(FacilitiesService facilitiesService) {
        this.facilitiesService = facilitiesService;
    }
    @GetMapping
    public List<Facilities> getAllFacilities() {
        return facilitiesService.getAllFacilities();
    }

}
