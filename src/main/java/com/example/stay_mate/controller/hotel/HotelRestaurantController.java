package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.HotelRestaurant;
import com.example.stay_mate.service.hotel.HotelRestaurantService;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel-restaurant")
public class HotelRestaurantController {
    private final HotelRestaurantService hotelRestaurantService;
    private final HotelService hotelService;
    private final PartnerService partnerService;

    public HotelRestaurantController(HotelRestaurantService hotelRestaurantService, HotelService hotelService, PartnerService partnerService) {
        this.hotelRestaurantService = hotelRestaurantService;
        this.hotelService = hotelService;
        this.partnerService = partnerService;
    }

    @GetMapping("/all")
    public String getAllHotelRestaurants(Model model) {
        model.addAttribute("all_hotel_restaurant", hotelRestaurantService.getAllHotelRestaurants());
        return "hotel-restaurant-list";
    }

    @GetMapping("/{id}")
    public String getCurrentHotelRestaurant(Model model, @PathVariable("id") Integer hotelRestaurantId) {
        model.addAttribute("hotel_restaurant", hotelRestaurantService.getHotelRestaurantById(hotelRestaurantId));
        return "hotel-restaurant";
    }

    @GetMapping("/create/{hotel-id}/{partner-id}")
    public String addHotelRestaurant(Model model, @PathVariable("hotel-id") Integer hotelId, @PathVariable("partner-id") Integer partnerId) {
        model.addAttribute("partnerId", partnerId);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("new_hotel_restaurant", new HotelRestaurant());
        return "new-hotel-restaurant-form";
    }

    @PostMapping("/create/{hotel-id}/{partner-id}")
    public String addHotelRestaurant(@ModelAttribute("new_hotel_restaurant") HotelRestaurant hotelRestaurant, @PathVariable("hotel-id") Integer hotelId, @PathVariable("partner-id") Integer partnerId) {
        hotelRestaurant.setPartner(partnerService.getPartnerById(partnerId));
        hotelRestaurant.setHotel(hotelService.getHotelById(hotelId));
        hotelRestaurantService.saveHotelRestaurant(hotelRestaurant);
        return "redirect:/hotels/" + hotelId + "/" + partnerId;
    }

    @GetMapping("/update/{id}")
    public String updateHotelRestaurant(@PathVariable("id") Integer hotelRestaurantId, Model model) {
        model.addAttribute("updated_hotel_restaurant", hotelRestaurantService.getHotelRestaurantById(hotelRestaurantId));
        return "hotel-restaurant-update";
    }

    @PostMapping("/update/{id}")
    public String updateHotelRestaurant(@ModelAttribute("updated_hotel_restaurant") HotelRestaurant updatedHotelRestaurant, @PathVariable("id") Integer hotelRestaurantId) {
        hotelRestaurantService.saveHotelRestaurant(updatedHotelRestaurant);
        return "redirect:/hotel-restaurant/" + hotelRestaurantId;
    }

    @PostMapping("/{id}/delete")
    public String deleteHotelRestaurant(@PathVariable("id")Integer hotelRestaurantId){
        hotelRestaurantService.deleteHotelRestaurantById(hotelRestaurantId);
        return "redirect:/partner/current";
    }
}
