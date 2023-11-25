package com.example.stay_mate.controller.user;

import com.example.stay_mate.model.user.User;
import com.example.stay_mate.service.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public UserController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/all") // ez a funkció várhatóan csak nekünk kellhet
    public String getAllPartners(Model model){
        model.addAttribute("all_users", userService.getAllUsers());
        return "all-users";
    }
    @GetMapping("/current")
    public String getCurrentUser(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        return "user";
    }
   @GetMapping("/create")
   public String addUser(Model model){
       model.addAttribute("new_user", new User());
       return "new-user-form";
   }

 //   @PostMapping("/create")
 //   public String addUser(@ModelAttribute("new_user") User user){
 //       userService.saveUser(user);
 //       return "redirect:/";
 //   }

    @PostMapping("{id}/delete")
    public String deleteUser(@PathVariable("id")Integer userId, User user){
        userService.deleteUser(user);
        return "redirect:/";
    }
    @GetMapping("/reg")
    public String getReg(Model model){
        model.addAttribute("newUser", new User());
        return "user-registration";
    }
    @PostMapping("/reg")
    public String saveUser(
            @ModelAttribute("newUser")
            User user
    ){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/user-login";
    }

    @GetMapping("/{id}/update")
    public String updatePartner(@PathVariable("id")Integer userId, Model model){
        model.addAttribute("user", userService.getUserById(userId));
        return "user-update";
    }
    @PostMapping("/{id}/update")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Integer id){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/user/current";
    }
}
