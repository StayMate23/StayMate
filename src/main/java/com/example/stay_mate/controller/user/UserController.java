package com.example.stay_mate.controller.user;

import com.example.stay_mate.model.user.User;
import com.example.stay_mate.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("post_url", "/new");
        return "user-form";
    }
    @PostMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editGuest(Model model, @PathVariable("id") Integer id){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("post_url", "/edit/" + id);
        return "user-form";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/user";
    }
}
