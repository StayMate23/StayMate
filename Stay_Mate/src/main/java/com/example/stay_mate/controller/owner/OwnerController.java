package com.example.stay_mate.controller.owner;

import com.example.stay_mate.model.owner.Owner;
import com.example.stay_mate.service.owner.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnerController {
    public final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owner/{id}")
    public String getOwnerById(Model model, @PathVariable("id") Integer id) {
        Owner owner = ownerService.getOwnerById(id);
        model.addAttribute("owner", owner);
        return "owner";
    }

    // TODO ide jöhet a partner hozzáadása:
    @GetMapping("/new")
    public String addOwner(Model model) {
        model.addAttribute("new_owner", new Owner());
        return "new-owner-form";
    }

    @PostMapping("/add")
    public String addOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/home";
        // LIA: itt nem tudom mi lenne a megfelelő, de arra gondoltam, hogy egy bejelentkezés utáni home page-re lehetne redirektálni
    }

    @GetMapping("/update/{id}")
    public String updateOwner(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("owner", ownerService.getOwnerById(id));
        return "owner-update";
    }

    @PostMapping("/update/{id}")
    public String updateOwner(@ModelAttribute("owner") Owner owner, @PathVariable("id") Integer id) {
        ownerService.saveOwner(owner);
        return "redirect:/owner/owner/" + id;
    }
}
