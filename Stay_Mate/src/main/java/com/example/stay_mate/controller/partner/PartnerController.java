package com.example.stay_mate.controller.partner;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.service.partner.PartnerAdminService;
import com.example.stay_mate.service.partner.PartnerService;
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
    private final PasswordEncoder passwordEncoder;

    public PartnerController(PartnerService partnerService, PartnerAdminService partnerAdminService, PasswordEncoder passwordEncoder) {
        this.partnerService = partnerService;
        this.partnerAdminService = partnerAdminService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/all")
    public String getAllPartners(Model model) {
        model.addAttribute("all_partners", partnerService.findAllPartner());
        return "partner-list";
    }

    @GetMapping("/current")
    public String getCurrentPartner(Model model, @AuthenticationPrincipal Partner partner) {
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
        return "redirect:/partner/all";
        // LIA: itt nem tudom mi lenne a megfelelő, de arra gondoltam, hogy egy bejelentkezés utáni home page-re lehetne redirektálni
    }

    @PostMapping("/{id}/delete")
    public String deletePartner(@PathVariable("id") Integer id, Partner partner) {
        partnerAdminService.deletePartnerAdminByPartner(partner);
        partnerService.deletePartnerById(id);
        return "redirect:/partner/all";
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

