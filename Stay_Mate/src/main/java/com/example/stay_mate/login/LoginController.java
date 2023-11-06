package com.example.stay_mate.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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