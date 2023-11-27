package com.example.stay_mate.controller.reservation;

import com.example.stay_mate.model.reservation.Reservation;
import com.example.stay_mate.service.ReservationService;
import com.example.stay_mate.service.bar.BarService;
import com.example.stay_mate.service.hotel.HotelBarService;
import com.example.stay_mate.service.hotel.HotelRestaurantService;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.partner.PartnerService;
import com.example.stay_mate.service.restaurant.RestaurantService;
import com.example.stay_mate.service.room.RoomService;
import com.example.stay_mate.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final PartnerService partnerService;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final BarService barService;
    private final HotelService hotelService;
    private final HotelRestaurantService hotelRestaurantService;
    private final HotelBarService hotelBarService;
    private final RoomService roomService;

    public ReservationController(ReservationService reservationService, PartnerService partnerService,
                                 UserService userService, RestaurantService restaurantService,
                                 BarService barService, HotelService hotelService,
                                 HotelRestaurantService hotelRestaurantService, HotelBarService hotelBarService,
                                 RoomService roomService) {
        this.reservationService = reservationService;
        this.partnerService = partnerService;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.barService = barService;
        this.hotelService = hotelService;
        this.hotelRestaurantService = hotelRestaurantService;
        this.hotelBarService = hotelBarService;
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public String getAllReservations() {
        reservationService.getAllReservation();
        return "all_reservations";
    }
    @GetMapping("/{user-id}")
    public String getAllRoom(Model model,
                             @PathVariable("user-id")Integer userId){
        model.addAttribute("room",roomService.getAllRooms());
        model.addAttribute("userId",userService.getUserById(userId));
        return "logged-in-room";
    }

    @GetMapping("/restaurant/{r_res-id}")
    public String getRestaurantReservations(Model model,
                                            @PathVariable("r_res-id") Integer rReservId) {
        model.addAttribute("res_reserv", reservationService.getReservationById(rReservId));
        return "restaurant-reservation";
    }

    @GetMapping("/bar/{b_res-id}")
    public String getBarReservations(Model model,
                                            @PathVariable("b_res-id") Integer bReservId) {
        model.addAttribute("res_reserv", reservationService.getReservationById(bReservId));
        return "bar-reservation";
    }

    @GetMapping("/hotel-restaurant/{hr_res-id}")
    public String getHotelRestaurantReservations(Model model,
                                            @PathVariable("hr_res-id") Integer h_r_ReservId) {
        model.addAttribute("res_reserv", reservationService.getReservationById(h_r_ReservId));
        return "hotel-restaurant-reservation";
    }

    @GetMapping("/hotel-bar/{hb_res-id}")
    public String getHotelBarReservations(Model model,
                                                 @PathVariable("hb_res-id") Integer h_b_ReservId) {
        model.addAttribute("res_reserv", reservationService.getReservationById(h_b_ReservId));
        return "hotel-bar-reservation";
    }

    @GetMapping("/user/{user-id}")
    public String getUserReservations(Model model,
                                          @PathVariable("user-id") Integer userReservId) {
        model.addAttribute("res_reserv", reservationService.getReservationById(userReservId));
        return "user-reservation";
    }

    @GetMapping("/{user-id}/create/date/{room-id}")
    // ez az elérés is változhat pl all avaibleRooms-ra vagy ezt majd megbeszéljük
    public String createRoomReservationDate(Model model,
                                            @PathVariable("room-id")Integer roomId,
                                            @PathVariable("user-id")Integer userId){
        model.addAttribute("new_reservation",new Reservation());
        model.addAttribute("roomId",roomService.getRoomById(roomId));
        model.addAttribute("userId",userService.getUserById(userId));
        return "reservation"; // itt majd ennek megfelelően adjuk meg az elérést
        // itt lehetne úgy, hogy egy oldalon beállítjuk a dátumot és a létszámot
        // betölti az összes elérhető szobát arra az időszakra?
    }
    @GetMapping("/{user-id}/create/{room-id}/{hotel-id}/{partner-id}")
    public String createRoomReservation(Model model,
                                        @ModelAttribute("new_reservation")Reservation newReservation,
                                        @PathVariable("user-id")Integer userId,
                                        @PathVariable("room-id")Integer roomId,
                                        @PathVariable("hotel-id")Integer hotelId,
                                        @PathVariable("partner-id")Integer partnerId){
        model.addAttribute("new_reservation",newReservation);
        model.addAttribute("userId",userId);
        model.addAttribute("partnerId",partnerId);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("roomId",roomId);
        model.addAttribute("availableRoom",roomService.getAllAvaibleRooms(
                newReservation.getStartDate(),
                newReservation.getEndDate(),
                newReservation.getUserNumber()
        ));
        return "reservation";
    }
    @PostMapping("/create/{user-id}/{room-id}/{hotel-id}/{partner-id}")
    public String createRoomReservation(@ModelAttribute("new_reservation")Reservation newReservation,
                                        @PathVariable("user-id")Integer userId,
                                        @PathVariable("room-id")Integer roomId,
                                        @PathVariable("hotel-id")Integer hotelId,
                                        @PathVariable("partner-id")Integer partnerId){
        newReservation.setUser(userService.getUserById(userId));
        newReservation.setPartner(partnerService.getPartnerById(partnerId));
        newReservation.setHotel(hotelService.getHotelById(hotelId));
        newReservation.setRoom(roomService.getRoomById(roomId));
        return "redirect:/";
        // itt is még ki kell találni, hogy hova menjen vissza pl egy visszaigazoló oldalra.
        // Tomi, ehhez tudsz írni egy emailes visszaigazoló metódust,
        // ami visszaadja a nevét, dátumot, összeget és a választott hotelt, szobát?
    }
}
