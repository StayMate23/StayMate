

package com.example.stay_mate.controller.restaurant;

import com.example.stay_mate.model.restaurant.Restaurant;
import com.example.stay_mate.service.partner.PartnerService;
import com.example.stay_mate.service.restaurant.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
   private final RestaurantService restaurantService;
   private final PartnerService partnerService;

    public RestaurantController(RestaurantService restaurantService, PartnerService partnerService) {
        this.restaurantService = restaurantService;
        this.partnerService = partnerService;
    }

    @GetMapping("/all")
    public String getAllRestaurants(Model model) {
        List<Restaurant> all_restaurant = restaurantService.getAllRestaurants();
        model.addAttribute("all_restaurant", all_restaurant);
        return "restaurant-list";
    }

    @GetMapping("/{id}")
    public String getCurrentRestaurant(Model model, @PathVariable("id") Integer restaurantId){
        model.addAttribute("restaurant", restaurantService.getRestaurantById(restaurantId));
        return "restaurant";
    }

    @GetMapping("/create/{partner-id}")
    public String addRestaurant(Model model, @PathVariable("partner-id")Integer partnerId) {
        model.addAttribute("partnerId",partnerId);
        model.addAttribute("new_restaurant", new Restaurant());
        return "new-restaurant-form";
    }

    @PostMapping("/create/{partner-id}")
    public String addRestaurant(@ModelAttribute("new_restaurant") Restaurant restaurant, @PathVariable("partner-id")Integer partnerId) {
        restaurant.setPartner(partnerService.getPartnerById(partnerId));
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/partner/current";
    }

    @GetMapping("/{id}/update")
    public String updateRestaurant(Model model, @PathVariable("id")Integer restaurantId){
        model.addAttribute("updated_restaurant", restaurantService.getRestaurantById(restaurantId));
        return "restaurant-update";
    }

    @PostMapping("/{id}/update")
    public String updateRestaurant(@ModelAttribute("updated_restaurant") Restaurant updatedRestaurant,@PathVariable("id")Integer restaurantId){
    restaurantService.saveRestaurant(updatedRestaurant);
    return "redirect:/partner/current";
    }

    @PostMapping("/{id}/delete")
    public String deleteRestaurants(@PathVariable("id") Integer id) {
        restaurantService.deleteRestaurantById(id);
        return "redirect:/partner/current";
    }

}
