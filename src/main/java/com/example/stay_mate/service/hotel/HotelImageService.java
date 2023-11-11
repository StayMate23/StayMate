package com.example.stay_mate.service.hotel;

import com.example.stay_mate.model.hotel.HotelImage;
import com.example.stay_mate.repository.hotel.HotelImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelImageService {
    public final HotelImageRepository imageRepository;

    public HotelImageService(HotelImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public List<HotelImage> getAllImages() {
        return imageRepository.findAll();
    }

    public void saveImage(HotelImage image) {
        imageRepository.save(image);
    }

    public Object getImageById(Integer id) {
       return imageRepository.findById(id);
    }

    public void save(HotelImage image) {
        imageRepository.save(image);
    }

    public Object findAllImage() {
        return imageRepository.findAll();
    }

    public void deleteImageById(Integer id) {
        imageRepository.deleteById(id);
    }
}
