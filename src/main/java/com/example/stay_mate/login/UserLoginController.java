package com.example.stay_mate.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserLoginController {
    @GetMapping("/user-login")
    String userLogin() {
        return "/user-login";
    }
    @PostMapping("/user-logout")
    public String userPerformLogout() {
        return "redirect:/home";
    }
}