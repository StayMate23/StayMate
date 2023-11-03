package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.Facilities;
import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.hotel.Image;
import com.example.stay_mate.service.hotel.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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


    @GetMapping("/image/{id}")
    public Object getImageById(Model model, @PathVariable("id") Integer id) {
        Image image = (Image) imageService.getImageById(id);
        model.addAttribute("image", image);
        return "image";
    }

    // TODO ide jöhet a partner hozzáadása:
    @GetMapping("/new")
    public String addImage(Model model) {
        model.addAttribute("new-image", new Image());
        return "new-image-form";
    }

    @PostMapping("/add")
    public String addImage(@ModelAttribute("image") Image image) {
        imageService.saveImage(image);
        return "redirect:/home";
        // LIA: itt nem tudom mi lenne a megfelelő, de arra gondoltam, hogy egy bejelentkezés utáni home page-re lehetne redirektálni
    }

    @GetMapping("/update/{id}")
    public String updateImage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("image", imageService.getImageById(id));
        return "image-update";
    }

    @PostMapping("/update/{id}")
    public String updateImage(@ModelAttribute("image") Image image, @PathVariable("id") Integer id) {
        imageService.saveImage(image);
        return "redirect:/image/image/" + id;
    }
}
