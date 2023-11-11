package com.example.stay_mate.service.user;

import com.example.stay_mate.model.user.Reservation;
import com.example.stay_mate.repository.user.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepo;
    public ReservationService(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public List<Reservation> reservationDates(LocalDate start, LocalDate end) {
        return reservationRepo.findAllByStartDateIsBetweenOrEndDateIsBetween(start, end, start, end);
    }

    public void save(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    @Transactional
    public void deleteReservationById(Integer id) {
        reservationRepo.removeById(id);
    }
}
