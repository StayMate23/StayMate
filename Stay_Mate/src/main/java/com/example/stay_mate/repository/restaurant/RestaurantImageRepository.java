package com.example.stay_mate.repository.restaurant;

import com.example.stay_mate.model.restaurant.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantImageRepository extends JpaRepository<RestaurantImage,Integer> {
}
