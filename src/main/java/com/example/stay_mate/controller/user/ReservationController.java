package com.example.stay_mate.controller.user;


import com.example.stay_mate.model.user.Reservation;
import com.example.stay_mate.service.room.RoomService;
import com.example.stay_mate.service.user.ReservationService;
import com.example.stay_mate.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final UserService userService;

    private final RoomService roomService;

    public ReservationController(ReservationService reservationService, UserService userService, RoomService roomService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @GetMapping("/new")
    public String createReservation(Model model, @ModelAttribute("reservation") Reservation reservation){
        System.out.println(reservation);
        model.addAttribute("reservation", reservation);
        model.addAttribute("rooms", roomService.getAllAvailableRooms(
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getUserNumber()));
        model.addAttribute("users", userService.findAllUser());
        return "new-reservation";
    }

    @PostMapping("/new")
    public String createReservation(@ModelAttribute("reservation") Reservation reservation){
        reservationService.save(reservation);
        return "redirect:/reservation";
    }

    @PostMapping("/delete/{id}")
    public String deleteReservation(@PathVariable("id") Integer id){
        reservationService.deleteReservationById(id);
        return "redirect:/reservation";
    }
}
