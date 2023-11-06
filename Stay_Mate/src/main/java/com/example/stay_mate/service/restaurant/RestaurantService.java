package com.example.stay_mate.service.restaurant;

import com.example.stay_mate.model.restaurant.Restaurant;
import com.example.stay_mate.repository.restaurant.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    public final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
