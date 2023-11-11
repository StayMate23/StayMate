

package com.example.stay_mate.controller.restaurant;

import com.example.stay_mate.model.restaurant.Restaurant;
import com.example.stay_mate.service.restaurant.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
   private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/all")
    public String getAllRestaurants(Model model) {
        List<Restaurant> all_restaurant = restaurantService.getAllRestaurants();
        model.addAttribute("all_restaurant", all_restaurant);
        return "restaurant-list";
    }

    @GetMapping("/create")
    public String addRestaurant(Model model) {
        model.addAttribute("new_restaurant", new Restaurant());
        return "new-restaurant-form";
    }

    @PostMapping("/create")
    public String addRestaurant(@ModelAttribute("bar") Restaurant restaurant) {
        restaurantService.save(restaurant);
        return "redirect:/restaurants/all";
    }

    @PostMapping("/{id}/delete")
    public String deleteRestaurants(@PathVariable("id") Integer id, Restaurant restaurant) {
        restaurantService.delete(restaurant);
        restaurantService.deleteRestaurantById(id);
        return "redirect:/restaurants/all";
    }

}
