package com.example.stay_mate.controller.partner;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.service.bar.BarService;
import com.example.stay_mate.service.hotel.FacilitiesService;
import com.example.stay_mate.service.hotel.HotelBarService;
import com.example.stay_mate.service.hotel.HotelRestaurantService;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.partner.PartnerAdminService;
import com.example.stay_mate.service.partner.PartnerService;
import com.example.stay_mate.service.restaurant.RestaurantService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerService;
    private final PartnerAdminService partnerAdminService;
    private final HotelService hotelService;
    private final FacilitiesService facilitiesService;
    private final BarService barService;
    private final RestaurantService restaurantService;
    private final HotelBarService hotelBarService;
    private final HotelRestaurantService hotelRestaurantService;
    private final PasswordEncoder passwordEncoder;

    public PartnerController(PartnerService partnerService, PartnerAdminService partnerAdminService,
                             HotelService hotelService, FacilitiesService facilitiesService, BarService barService,
                             RestaurantService restaurantService, HotelBarService hotelBarService,
                             HotelRestaurantService hotelRestaurantService, PasswordEncoder passwordEncoder) {
        this.partnerService = partnerService;
        this.partnerAdminService = partnerAdminService;
        this.hotelService = hotelService;
        this.facilitiesService = facilitiesService;
        this.barService = barService;
        this.restaurantService = restaurantService;
        this.hotelBarService = hotelBarService;
        this.hotelRestaurantService = hotelRestaurantService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/all")
    public String getAllPartners(Model model) {
        model.addAttribute("all_partners", partnerService.findAllPartner());
        return "partner-list";
    }

    @GetMapping("/current")
    public String getCurrentPartner(Model model, @AuthenticationPrincipal Partner partner) {
        model.addAttribute("hotel_restaurant", hotelRestaurantService.getHotelRestaurantByPartner(partner));
        model.addAttribute("hotel_bar", hotelBarService.getHotelBarByPartner(partner));
        model.addAttribute("restaurant", restaurantService.getRestaurantByPartner(partner));
        model.addAttribute("bar", barService.getBarByPartner(partner));
        model.addAttribute("facilities", facilitiesService.getFacilitiesByPartner(partner));
        model.addAttribute("hotel", hotelService.getHotelByPartner(partner));
        model.addAttribute("partner_admin", partnerAdminService.getAllPartnerAdminByPartner(partner));
        model.addAttribute("partner", partner);
        return "partner";
    }

    @GetMapping("/create")
    public String addPartner(Model model) {
        model.addAttribute("new_partner", new Partner());
        return "new-partner-form";
    }

    @PostMapping("/create")
    public String addPartner(@ModelAttribute("partner") Partner partner) {
        partnerService.savePartner(partner);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deletePartner(@PathVariable("id") Integer id, Partner partner) {
        hotelRestaurantService.deleteHotelRestaurantByPartner(partner);
        hotelBarService.deleteBarByPartner(partner);
        restaurantService.deleteRestaurantByPartner(partner);
        barService.deleteBarByPartner(partner);
        facilitiesService.deleteFacilitiesByPartner(partner);
        hotelService.deleteHotelByPartner(partner);
        partnerAdminService.deletePartnerAdminByPartner(partner);
        partnerService.deletePartnerById(id);
        return "deleted-account";
    }

    @GetMapping("/reg")
    public String getReg(Model model) {
        model.addAttribute("newPartner", new Partner());
        return "registration";
    }

    @PostMapping("/reg")
    public String saveUser(
            @ModelAttribute("newPartner")
            Partner partner
    ) {
        partner.setPassword(passwordEncoder.encode(partner.getPassword()));
        partnerService.savePartner(partner);
        return "redirect:/login";
    }

    @GetMapping("/{id}/update")
    // @PreAuthorize("hasRole('ADMIN')")
    public String updatePartner(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("partner", partnerService.getPartnerById(id));
        return "partner-update";
    }

    @PostMapping("/{id}/update")
    public String updatePartner(@ModelAttribute("partner") Partner partner, @PathVariable("id") Integer id) {
        partner.setPassword(passwordEncoder.encode(partner.getPassword()));
        partnerService.savePartner(partner);
        return "redirect:/partner/current";
    }
}

