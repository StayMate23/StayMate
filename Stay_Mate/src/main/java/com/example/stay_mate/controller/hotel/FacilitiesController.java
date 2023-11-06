package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.owner.Owner;
import com.example.stay_mate.service.hotel.FacilitiesService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/facilities/{id}")
    public String getFacilitiesById(Model model, @PathVariable("id") Integer id) {
        Facilities facilities = facilitiesService.getFacilitiesById(id);
        model.addAttribute("facilities", facilities);
        return "facilities";
    }

    @GetMapping("/new")
    public String addFacilities(Model model) {
        model.addAttribute("new-facilities", new Facilities());
        return "new-facilities-form";
    }

    @PostMapping("/add")
    public String addFacilities(@ModelAttribute("facilities") Facilities facilities) {
        facilitiesService.saveFacilities(facilities);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String updateFacilities(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("facilities", facilitiesService.getFacilitiesById(id));
        return "facilities-update";
    }

    @PostMapping("/update/{id}")
    public String updateFacilities(@ModelAttribute("facilities") Facilities facilities, @PathVariable("id") Integer id) {
        facilitiesService.saveFacilities(facilities);
        return "redirect:/facilities/facilities/" + id;
    }

}
