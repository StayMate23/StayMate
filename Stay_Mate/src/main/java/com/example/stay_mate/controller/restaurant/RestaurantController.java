package com.example.stay_mate.controller.restaurant;

import com.example.stay_mate.model.restaurant.Restaurant;
import com.example.stay_mate.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public  RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }
}
