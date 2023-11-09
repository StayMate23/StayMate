package com.example.stay_mate.controller.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.service.bar.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bars")
public class BarController {
    private final BarService barService;
    @Autowired
    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping("/all")
    public String getAllBars(Model model) {
        model.addAttribute("all_bars", barService.findAllBar());
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
        return "redirect:/bar/all";
    }

    @GetMapping("/{id}/update")
    // @PreAuthorize("hasRole('ADMIN')")
    public String updateBar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bar", barService.getBarById(id));
        return "bar-update";
    }

    @PostMapping("/{id}/update")
    public String updateBar(@ModelAttribute("bar") Bar bar, @PathVariable("id") Integer id) {
        barService.save(bar);
        return "redirect:/bars";
    }
    @PostMapping("/{id}/delete")
    public String deleteBar(@PathVariable("id") Integer id, Bar bar) {
        barService.deleteBarById(id);
        return "redirect:/bar/all";
    }
}
