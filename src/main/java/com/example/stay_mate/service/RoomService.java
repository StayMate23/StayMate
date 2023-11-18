package com.example.stay_mate.service;

import com.example.stay_mate.model.hotel.Hotel;
import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.model.room.Room;
import com.example.stay_mate.repository.room.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService {
    public final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    public void saveRoom(Room room){
        roomRepository.save(room);
    }
    public Room getRoomById(Integer id){
        return roomRepository.findById(id).orElse(null);
    }
    public List<Room> getRoomByPartner(Partner partner){
        return roomRepository.getRoomByPartner(partner);
    }
    public List<Room> getRoomByHotel(Hotel hotel){
        return roomRepository.getRoomByHotel(hotel);
    }
    @Transactional
    public void deleteRoomById(Integer id){
        roomRepository.deleteById(id);
    }
    @Transactional
    public void deleteRoomByPartner(Partner partner){
        roomRepository.deleteRoomByPartner(partner);
    }
    @Transactional
    public void deleteRoomByHotel(Hotel hotel){
        roomRepository.deleteRoomByHotel(hotel);
    }
}
