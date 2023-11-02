package com.example.stay_mate.service.hotel;

import com.example.stay_mate.model.hotel.Image;
import com.example.stay_mate.repository.hotel.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    public final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
