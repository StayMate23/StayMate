package com.example.stay_mate.controller;

import com.example.stay_mate.model.Partner;
import com.example.stay_mate.service.PartnerAdminService;
import com.example.stay_mate.service.PartnerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }
    @PostMapping("/logout")
    public String performLogout() {
        return "redirect:/home";
    }
}