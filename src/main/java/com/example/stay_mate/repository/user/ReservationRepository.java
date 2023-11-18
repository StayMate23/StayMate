package com.example.stay_mate.repository.user;

import com.example.stay_mate.model.user.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findAllByStartDateIsBetweenOrEndDateIsBetween(LocalDate start, LocalDate end, LocalDate startDate, LocalDate endDate);
    void removeById(Integer id);
}
