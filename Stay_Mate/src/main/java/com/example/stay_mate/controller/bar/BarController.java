package com.example.stay_mate.controller.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.service.bar.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bars")
public class BarController {
    private final BarService barService;
    @Autowired
    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping
    public List<Bar> getAllBars() {
        return barService.getAllBars();
    }

}
