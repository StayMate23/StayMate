package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.HotelBar;
import com.example.stay_mate.service.hotel.HotelBarService;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.menubook.MenuBookService;
import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel-bar")
public class HotelBarController {
    private final HotelBarService hotelBarService;
    private final HotelService hotelService;
    private final PartnerService partnerService;
    private final MenuBookService menuBookService;

    public HotelBarController(HotelBarService hotelBarService, HotelService hotelService,
                              PartnerService partnerService, MenuBookService menuBookService) {
        this.hotelBarService = hotelBarService;
        this.hotelService = hotelService;
        this.partnerService = partnerService;
        this.menuBookService = menuBookService;
    }

    @GetMapping("/all")
    public String getAllHotelBars(Model model) {
        model.addAttribute("all_hotel_bar", hotelBarService.findAllHotelBars());
        return "hotel-bar-list";
    }

    @GetMapping("/{id}")
    public String getCurrentHotelBar(Model model, @PathVariable("id") Integer hotelBarId) {
        model.addAttribute("menu_book",
                menuBookService.getMenuBookByHotelBar(hotelBarService.getHotelBarById(hotelBarId)));
        model.addAttribute("hotel_bar", hotelBarService.getHotelBarById(hotelBarId));
        return "hotel-bar";
    }

    @GetMapping("/create/{hotel-id}/{partner-id}")
    public String addHotelBar(Model model, @PathVariable("hotel-id") Integer hotelId, @PathVariable("partner-id") Integer partnerId) {
        model.addAttribute("partnerId", partnerId);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("new_hotel_bar", new HotelBar());
        return "new-hotel-bar-form";
    }

    @PostMapping("/create/{hotel-id}/{partner-id}")
    public String addHotelBar(@ModelAttribute("new_hotel_bar") HotelBar hotelBar, @PathVariable("hotel-id") Integer hotelId, @PathVariable("partner-id") Integer partnerId) {
        hotelBar.setPartner(partnerService.getPartnerById(partnerId));
        hotelBar.setHotel(hotelService.getHotelById(hotelId));
        hotelBarService.saveHotelBar(hotelBar);
        return "redirect:/hotels/" + hotelId + "/" + partnerId;
    }

    @GetMapping("/update/{id}")
    public String updateHotelBar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updated_hotel_bar", hotelBarService.getHotelBarById(id));
        return "hotel_bar_update";
    }
    @PostMapping("/update/{id}")
    public String updateHotelBar(@ModelAttribute("updated_hotel_bar")HotelBar hotelBar, @PathVariable("id")Integer hotelBarId){
        hotelBarService.saveHotelBar(hotelBar);
        return "redirect:/hotel-bar/" + hotelBarId;
    }
    @PostMapping("/{id}/delete")
    public String deleteHotelBar(@PathVariable("id")Integer hotelBarId, HotelBar hotelBar){
        menuBookService.deleteMenuBookByHotelBar(hotelBarService.getHotelBarById(hotelBarId));
        hotelBarService.deleteHotelBarById(hotelBarId);
        return "redirect:/partner/current";
    }
}

