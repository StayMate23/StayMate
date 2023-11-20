package com.example.stay_mate.controller.hotel;

import com.example.stay_mate.model.hotel.HotelImage;
import com.example.stay_mate.service.hotel.HotelImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images/hotels")
public class HotelImageController {
    public final HotelImageService imageService;

    public HotelImageController(HotelImageService imageService) {
        this.imageService = imageService;
    }
    @GetMapping
    public List<HotelImage> getAllImage() {
        return imageService.getAllImages();
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("imageDescription") String description,
                                              @RequestParam("imageFile") MultipartFile imageFile) {
        // Fájl mentése, adatbázisban való elmentés és egyéb műveletek
        // Példa: imageService.saveImage(description, imageFile);
        return ResponseEntity.ok("Kép sikeresen feltöltve.");
    }

    @GetMapping("/all")
    public String getAllImage(Model model) {
        model.addAttribute("all_image", imageService.findAllImage());
        return "image-list";
    }


    @GetMapping("/create")
    public String addImage(Model model) {
        model.addAttribute("new_image", new HotelImage());
        return "new-image-form";
    }

    @PostMapping("/create")
    public String addImage(@ModelAttribute("image") HotelImage image) {
        imageService.save(image);
        return "redirect:/images/all";
    }

    @GetMapping("/{id}/update")
    // @PreAuthorize("hasRole('ADMIN')")
    public String updateImage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("image", imageService.getImageById(id));
        return "image-update";
    }

    @PostMapping("/{id}/update")
    public String updateHotel(@ModelAttribute("hotel") HotelImage image, @PathVariable("id") Integer id) {
        imageService.save(image);
        return "redirect:/images";
    }
    @PostMapping("/{id}/delete")
    public String deleteImage(@PathVariable("id") Integer id, HotelImage image) {
        imageService.deleteImageById(id);
        return "redirect:/images/all";
    }
}
