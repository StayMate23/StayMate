package com.example.stay_mate.service.restaurant;

import com.example.stay_mate.model.restaurant.RestaurantImage;
import com.example.stay_mate.repository.restaurant.RestaurantImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantImageService {
    public final RestaurantImageRepository imageRepository;

    public RestaurantImageService(RestaurantImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public List<RestaurantImage> getAllImages() {
        return imageRepository.findAll();
    }

    public void saveImage(RestaurantImage image) {
        imageRepository.save(image);
    }

    public Object getImageById(Integer id) {
        return imageRepository.findById(id);
    }
}