package com.example.stay_mate.service.bar;

import com.example.stay_mate.model.bar.BarImage;
import com.example.stay_mate.repository.bar.BarImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarImageService {
    public final BarImageRepository barImageRepository;

    public BarImageService(BarImageRepository barImageRepository) {
        this.barImageRepository = barImageRepository;
    }
    public List<BarImage> getAllImages() {
        return barImageRepository.findAll();
    }

    public void saveImage(BarImage image) {
        barImageRepository.save(image);
    }

    public Object getImageById(Integer id) {
        return barImageRepository.findById(id);
    }
}
