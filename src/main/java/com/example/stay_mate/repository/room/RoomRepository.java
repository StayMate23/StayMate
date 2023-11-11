package com.example.stay_mate.repository.room;

import com.example.stay_mate.model.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findAllByIdNotInAndRoomCapacityGreaterThanEqual(Collection<Integer> ids, Integer guestNumber);
    List<Room> findAllByPriceLessThan(int price);
}
