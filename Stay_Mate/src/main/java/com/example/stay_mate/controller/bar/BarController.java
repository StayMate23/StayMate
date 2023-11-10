package com.example.stay_mate.controller.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.service.bar.BarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bars")
public class BarController {
    private final BarService barService;

    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping("/all")
    public String getAllBars(Model model) {
        List<Bar> all_bars = barService.findAllBar(); // Kapd meg az összes "bar" objektum listáját a szolgáltatás segítségével
        model.addAttribute("all_bars", all_bars); // Adj hozzá az összes "bar" objektumot a modellhez
        return "bar-list";
    }

    @GetMapping("/create")
    public String addBar(Model model) {
        model.addAttribute("new_bar", new Bar());
        return "new-bar-form";
    }

    @PostMapping("/create")
    public String addBar(@ModelAttribute("bar") Bar bar) {
        barService.save(bar);
        return "redirect:/bars/all";
    }

    @PostMapping("/{id}/delete")
    public String deleteBar(@PathVariable("id") Integer id, Bar bar) {
        barService.deleteBarById(id);
        return "redirect:/bars/all";
    }

}
