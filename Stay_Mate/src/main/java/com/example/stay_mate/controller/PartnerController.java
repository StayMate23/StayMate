package com.example.stay_mate.controller;

import com.example.stay_mate.model.Partner;
import com.example.stay_mate.service.PartnerAdminService;
import com.example.stay_mate.service.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerService;
    private final PartnerAdminService partnerAdminService;

    public PartnerController(PartnerService partnerService, PartnerAdminService partnerAdminService) {
        this.partnerService = partnerService;
        this.partnerAdminService = partnerAdminService;
    }

    @GetMapping("/partner/{id}")
    public String getPartnerById(Model model, @PathVariable("id") Integer id) {
        Partner partner = partnerService.getPartnerById(id);
        model.addAttribute("partner_admin", partnerAdminService.getAllPartnerAdminByPartner(partner));
        model.addAttribute("partner", partner);
        return "partner";
    }

    // TODO ide jöhet a partner hozzáadása:
    @GetMapping("/new")
    public String addPartner(Model model) {
        model.addAttribute("new_partner", new Partner());
        return "new-partner-form";
    }

    @PostMapping("/add")
    public String addPartner(@ModelAttribute("partner") Partner partner) {
        partnerService.savePartner(partner);
        return "redirect:/home";
        // LIA: itt nem tudom mi lenne a megfelelő, de arra gondoltam, hogy egy bejelentkezés utáni home page-re lehetne redirektálni
    }

    @GetMapping("/update/{id}")
    public String updatePartner(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("partner", partnerService.getPartnerById(id));
        return "partner-update";
    }

    @PostMapping("/update/{id}")
    public String updatePartner(@ModelAttribute("partner") Partner partner, @PathVariable("id") Integer id) {
        partnerService.savePartner(partner);
        return "redirect:/partner/partner/" + id;
    }
}
