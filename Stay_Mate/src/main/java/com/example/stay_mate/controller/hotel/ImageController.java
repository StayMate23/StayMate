package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.hotel.Image;
import com.example.stay_mate.service.hotel.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    public final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @GetMapping
    public List<Image> getAllImage() {
        return imageService.getAllImages();
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("imageDescription") String description,
                                              @RequestParam("imageFile") MultipartFile imageFile) {
        // Fájl mentése, adatbázisban való elmentés és egyéb műveletek
        // Példa: imageService.saveImage(description, imageFile);
        return ResponseEntity.ok("Kép sikeresen feltöltve.");
    }
}
