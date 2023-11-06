package com.example.stay_mate.repository.restaurant;

import com.example.stay_mate.model.restaurant.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
}
