package com.example.stay_mate.service.restaurant;

import com.example.stay_mate.model.restaurant.Image;
import com.example.stay_mate.repository.restaurant.ImageRepository;
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

    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    public Object getImageById(Integer id) {
        return imageRepository.findById(id);
    }
}
