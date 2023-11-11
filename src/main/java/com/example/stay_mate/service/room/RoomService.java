package com.example.stay_mate.service.room;

import com.example.stay_mate.model.user.Reservation;
import com.example.stay_mate.model.room.Room;
import com.example.stay_mate.repository.room.RoomRepository;
import com.example.stay_mate.service.user.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReservationService reservationService;

    public RoomService(RoomRepository roomRepository, ReservationService reservationService) {
        this.roomRepository = roomRepository;
        this.reservationService = reservationService;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> getAllAvailableRooms(LocalDate startDate, LocalDate endDate, Integer guestNumber) {
        List<Reservation> wrongReservations = reservationService.reservationDates(startDate,endDate);
        Set<Integer> wrongRoomId = new HashSet<>();
        for (Reservation actual: wrongReservations) {
            wrongRoomId.add(actual.getRoom().getId());
        }
        return roomRepository.findAllByIdNotInAndRoomCapacityGreaterThanEqual(wrongRoomId, guestNumber);
    }

    public void updateRoom(Room room) {
        roomRepository.save(room);
    }
}
