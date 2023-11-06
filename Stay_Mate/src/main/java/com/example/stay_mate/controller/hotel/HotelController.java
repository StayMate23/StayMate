package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public String getAllHotels(Model model) {
        model.addAttribute("all_hotels", hotelService.findAllHotel());
        return "hotel-list";
    }

    @GetMapping("/create")
    public String addHotel(Model model) {
        model.addAttribute("new_hotel", new Hotel());
        return "new-hotel-form";
    }

    @PostMapping("/create")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotel/all";
    }

    @GetMapping("/{id}/update")
    // @PreAuthorize("hasRole('ADMIN')")
    public String updateHotel(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        return "hotel-update";
    }

    @PostMapping("/{id}/update")
    public String updateHotel(@ModelAttribute("hotel") Hotel hotel, @PathVariable("id") Integer id) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }
    @PostMapping("/{id}/delete")
    public String deleteHotel(@PathVariable("id") Integer id, Hotel hotel) {
        hotelService.deleteHotelById(id);
        return "redirect:/hotel/all";
    }
}
