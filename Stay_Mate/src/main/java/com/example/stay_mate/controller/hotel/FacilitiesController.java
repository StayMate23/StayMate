package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.service.hotel.FacilitiesService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class FacilitiesController {

    private final FacilitiesService facilitiesService;

    public FacilitiesController(FacilitiesService facilitiesService) {
        this.facilitiesService = facilitiesService;
    }
    @GetMapping("/all")
    public String getAllFacilities(Model model) {
        model.addAttribute("all_services", facilitiesService.findAllFacilities());
        return "facilities-list";
    }

    @GetMapping("/create")
    public String addFacilities(Model model) {
        model.addAttribute("new-facilities", new Facilities());
        return "new-facilities-form";
    }

    @PostMapping("/create")
    public String addFacilities(@ModelAttribute("facilities") Facilities facilities) {
        facilitiesService.saveFacilities(facilities);
        return "redirect:/facilities-list";
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
    @PostMapping("/{id}/delete")
    public String deleteFacilities(@PathVariable("id") Integer id, Hotel hotel) {
        facilitiesService.deleteFacilitiesById(id);
        return "redirect:/hotel/all";
    }

}
