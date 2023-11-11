package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.service.hotel.FacilitiesService;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final PartnerService partnerService;
    private final FacilitiesService facilitiesService;

    public HotelController(HotelService hotelService, PartnerService partnerService, FacilitiesService facilitiesService) {
        this.hotelService = hotelService;
        this.partnerService = partnerService;
        this.facilitiesService = facilitiesService;
    }

    //  @GetMapping("/all")
  //  public String getAllHotels(Model model) {
  //      model.addAttribute("hotels", hotelService.findAllHotel());
  //      return "hotel-list";
  //  }
    @GetMapping("/{id}/{partner-id}")
    public String getCurrentHotel(Model model, @PathVariable("id") Integer id, @PathVariable("partner-id") Integer partnerId){
        model.addAttribute("partner", partnerService.getPartnerById(partnerId));
        model.addAttribute("facilities",facilitiesService.getFacilitiesByHotel(hotelService.getHotelById(id)));
        model.addAttribute("hotel",hotelService.getHotelById(id));
        return "hotel";
    }

    @GetMapping("/create/{partner-id}")
    public String addHotel(Model model, @PathVariable("partner-id") Integer partnerId) {
        model.addAttribute("partnerId", partnerId);
        model.addAttribute("new_hotel", new Hotel());
        return "new-hotel-form";
    }

    @PostMapping("/create/{partner-id}")
    public String addHotel(@ModelAttribute("new_hotel") Hotel hotel, @PathVariable("partner-id") Integer partnerId) {
        hotel.setPartner(partnerService.getPartnerById(partnerId));
        hotelService.saveHotel(hotel);
        return "redirect:/partner/current";
    }

    @GetMapping("/{id}/update")
    // @PreAuthorize("hasRole('ADMIN')")
    public String updateHotel(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("update_hotel", hotelService.getHotelById(id));
        return "hotel-update";
    }

    @PostMapping("/{id}/update")
    public String updateHotel(@ModelAttribute("update_hotel") Hotel updated, @PathVariable("id") Integer id) {
        hotelService.saveHotel(updated);
        return "redirect:/partner/current";
    }

    @PostMapping("/delete/{hotel-id}")
    public String deleteHotel(@PathVariable("hotel-id") Integer id) {
        facilitiesService.deleteFacilitiesByHotel(hotelService.getHotelById(id));
        hotelService.deleteHotelById(id);
        return "redirect:/partner/current";
    }
}
