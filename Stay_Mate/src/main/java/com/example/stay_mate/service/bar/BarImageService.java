package com.example.stay_mate.service.bar;

import com.example.stay_mate.model.bar.BarImage;
import com.example.stay_mate.repository.bar.BarImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarImageService {
    public final BarImageRepository ImageRepository;

    public BarImageService(BarImageRepository ImageRepository) {
        this.ImageRepository = ImageRepository;
    }
    public List<BarImage> getAllImages() {
        return ImageRepository.findAll();
    }

    public void saveImage(BarImage image) {
        ImageRepository.save(image);
    }

    public Object getImageById(Integer id) {
        return ImageRepository.findById(id);
    }
    public void save(BarImage image) {
        ImageRepository.save(image);
    }

    public Object findAllImage() {
        return ImageRepository.findAll();
    }

    public void deleteImageById(Integer id) {
        ImageRepository.deleteById(id);
    }

}
