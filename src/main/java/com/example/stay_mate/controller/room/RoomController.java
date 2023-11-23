package com.example.stay_mate.controller.room;

import com.example.stay_mate.model.room.Room;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.stay_mate.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    private final PartnerService partnerService;

    public RoomController(RoomService roomService, HotelService hotelService, PartnerService partnerService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.partnerService = partnerService;
    }

    @GetMapping("/all")
    public String getAllRooms(Model model) {
        model.addAttribute("all_rooms", roomService.getAllRooms());
        return "room-list";
    }

    @GetMapping("/{id}")
    public String getCurrentRoom(Model model, @PathVariable("id") Integer roomId) {
        model.addAttribute("room", roomService.getRoomById(roomId));
        return "room";
    }

    @GetMapping("/create/{hotel-id}/{partner-id}")
    public String createRoom(Model model,
                             @PathVariable("hotel-id") Integer hotelId,
                             @PathVariable("partner-id") Integer partnerId) {
        model.addAttribute("partnerId", partnerId);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("new_room", new Room());
        return "new-room-form";
    }

    @PostMapping("/create/{hotel-id}/{partner-id}")
    public String createRoom(@ModelAttribute("new_room") Room newRoom,
                             @PathVariable("hotel-id") Integer hotelId,
                             @PathVariable("partner-id") Integer partnerId) {
        newRoom.setPartner(partnerService.getPartnerById(partnerId));
        newRoom.setHotel(hotelService.getHotelById(hotelId));
        roomService.saveRoom(newRoom);
        return "redirect:/hotels/" + hotelId + "/" + partnerId;
    }

    @GetMapping("/update/{id}")
    public String updateRoom(Model model,
                             @PathVariable("id") Integer roomId) {
        model.addAttribute("updated_room", roomService.getRoomById(roomId));
        return "update-room-form";
    }

    @PostMapping("/update/{id}")
    public String updateRoom(@ModelAttribute("updated_room") Room updatedRoom,
                             @PathVariable("id") Integer roomId) {
        roomService.saveRoom(updatedRoom);
        return "redirect:/" + roomId;
    }
    @PostMapping("/{id}/delete")
    public String deleteRoom(@PathVariable("id")Integer roomId){
        roomService.deleteRoomById(roomId);
        return "redirect:/partner/current";
    }
}
