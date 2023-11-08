package com.example.stay_mate.controller.restaurant;

import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.restaurant.Restaurant;
import com.example.stay_mate.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public  RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public String getAllRestaurants(Model model){
        model.addAttribute("all_restaurants",restaurantService.findAllRestaurant());
        return "restaurant-list";
    }

    @GetMapping("/create")
    public String addRestaurant(Model model) {
        model.addAttribute("new_restaurant", new Restaurant());
        return "new-restaurant-form";
    }

    @PostMapping("/create")
    public String addRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        restaurantService.save(restaurant);
        return "redirect:/restaurant/all";
    }

    @GetMapping("/{id}/update")
    // @PreAuthorize("hasRole('ADMIN')")
    public String updateRestaurant(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("restaurant", restaurantService.getRestaurantById(id));
        return "restaurant-update";
    }

    @PostMapping("/{id}/update")
    public String updateRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, @PathVariable("id") Integer id) {
        restaurantService.save(restaurant);
        return "redirect:/restaurants";
    }
    @PostMapping("/{id}/delete")
    public String deleteRestaurant(@PathVariable("id") Integer id, Restaurant restaurant) {
        restaurantService.deleteRestaurantById(id);
        return "redirect:/restaurant/all";
    }
}
