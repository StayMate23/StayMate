package com.example.stay_mate.controller.room;

import com.example.stay_mate.model.room.Room;
import com.example.stay_mate.service.room.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "room-list";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("room", roomService.getRoomById(id));
        return "room";
    }

    @GetMapping("/edit/{id}")
    public String editRoom(Model model, @PathVariable("id") Integer id){
        model.addAttribute("room", roomService.getRoomById(id));
        return "room-form";
    }

    @PostMapping("/edit/{id}")
    public String editRoom(@ModelAttribute("room") Room room){
        roomService.updateRoom(room);
        return "redirect:/room";
    }

}
