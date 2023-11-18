package com.example.stay_mate.controller.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.service.bar.BarService;
import com.example.stay_mate.service.menubook.MenuBookService;
import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bars")
public class BarController {
    private final BarService barService;
    private final MenuBookService menuBookService;
    private final PartnerService partnerService;

    public BarController(BarService barService, MenuBookService menuBookService, PartnerService partnerService) {
        this.barService = barService;
        this.menuBookService = menuBookService;
        this.partnerService = partnerService;
    }

    @GetMapping("/all")
    public String getAllBars(Model model) {
        List<Bar> all_bars = barService.findAllBar();
        model.addAttribute("all_bars", all_bars);
        return "bar-list";
    }

    @GetMapping("/{id}")
    public String getCurrentBar(Model model, @PathVariable("id") Integer barId) {
        model.addAttribute("menu_book",menuBookService.getMenuBookByBar
                (barService.getBarById(barId)));
        model.addAttribute("bar", barService.getBarById(barId));
        return "bar";
    }

    @GetMapping("/create/{partner-id}")
    public String addBar(Model model, @PathVariable("partner-id") Integer partnerId) {
        model.addAttribute("partnerId", partnerId);
        model.addAttribute("new_bar", new Bar());
        return "new-bar-form";
    }

    @PostMapping("/create/{partner-id}")
    public String addBar(@ModelAttribute("new_bar") Bar bar, @PathVariable("partner-id") Integer partnerId) {
        bar.setPartner(partnerService.getPartnerById(partnerId));
        barService.saveBar(bar);
        return "redirect:/partner/current";
    }

    @GetMapping("/{id}/update")
    public String updateBar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updated_bar", barService.getBarById(id));
        return "bar-update";
    }

    @PostMapping("/{id}/update")
    public String updateBar(@PathVariable("id") Integer id, @ModelAttribute("updated_bar") Bar updatedBar) {
        barService.saveBar(updatedBar);
        return "redirect:/partner/current";
    }


    @PostMapping("/{bar-id}/delete")
    public String deleteBar(@PathVariable("bar-id") Integer barId) {
        menuBookService.deleteMenuBookByBar(barService.getBarById(barId));
        barService.deleteBarById(barId);
        return "redirect:/partner/current";
    }

}
