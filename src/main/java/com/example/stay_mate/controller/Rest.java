package com.example.stay_mate.controller;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.model.partner.PartnerAdmin;
import com.example.stay_mate.model.room.Room;
import com.example.stay_mate.model.user.Reservation;
import com.example.stay_mate.model.user.User;
import com.example.stay_mate.service.partner.PartnerAdminService;
import com.example.stay_mate.service.partner.PartnerService;
import com.example.stay_mate.service.room.RoomService;
import com.example.stay_mate.service.user.ReservationService;
import com.example.stay_mate.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class Rest {
    public final PartnerService partnerService;
    public final PartnerAdminService partnerAdminService;

    public final UserService userService;
    public final ReservationService reservationService;
    public final RoomService roomService;

    public Rest(PartnerService partnerService, PartnerAdminService partnerAdminService, UserService userService, ReservationService reservationService, RoomService roomService) {
        this.partnerService = partnerService;
        this.partnerAdminService = partnerAdminService;
        this.userService = userService;
        this.reservationService = reservationService;
        this.roomService = roomService;
    }

    @GetMapping("/partners")
    public List<Partner> getAllPartners() {
        return partnerService.findAllPartner();
    }

    @GetMapping("/partner_admins")
    public List<PartnerAdmin> getAllPartnerAdmins() {
        return partnerAdminService.findAllPartnerAdmins();
    }

    @GetMapping("/partner/{id}/partner-admin")
    public List<PartnerAdmin> getAllPartnerAdminsByPartner(@PathVariable("id") Integer id) {
        return partnerAdminService.getAllPartnerAdminByPartner(partnerService.getPartnerById(id));
    }
    @GetMapping("/users")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }


}
