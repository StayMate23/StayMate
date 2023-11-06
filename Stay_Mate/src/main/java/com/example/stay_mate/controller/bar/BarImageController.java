package com.example.stay_mate.controller.bar;


import com.example.stay_mate.model.bar.BarImage;
import com.example.stay_mate.service.bar.BarImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/bar-images")
public class BarImageController {
    public final BarImageService barImageService;

    public BarImageController(BarImageService barImageService) {
        this.barImageService = barImageService;
    }
    @GetMapping
    public List<BarImage> getAllImage() {
        return barImageService.getAllImages();
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
        BarImage barImage = (BarImage) barImageService.getImageById(id);
        model.addAttribute("image", barImage);
        return "bar-image";
    }

    @GetMapping("/new")
    public String addImage(Model model) {
        model.addAttribute("new-image", new BarImage());
        return "new-image-form-bar";
    }

    @PostMapping("/add")
    public String addImage(@ModelAttribute("image") BarImage barImage) {
        barImageService.saveImage(barImage);
        return "redirect:/home";
        // LIA: itt nem tudom mi lenne a megfelelő, de arra gondoltam, hogy egy bejelentkezés utáni home page-re lehetne redirektálni
    }

    @GetMapping("/update/{id}")
    public String updateImage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("image", barImageService.getImageById(id));
        return "image-update-bar";
    }

    @PostMapping("/update/{id}")
    public String updateImage(@ModelAttribute("image") BarImage barImage, @PathVariable("id") Integer id) {
        barImageService.saveImage(barImage);
        return "redirect:/image/image/" + id;
    }
}

