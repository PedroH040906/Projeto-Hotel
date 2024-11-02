package service;

import domain.Rooms;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.RoomsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomsService {

    private final RoomsRepository roomsRepository;

    public Rooms addRoom(RoomsDTO roomsDTO) {
        Rooms room = new Rooms();
        room.setRoomNumber(roomsDTO.getRoomNumber());
        room.setRoomType(roomsDTO.getRoomType());
        room.setFloor(roomsDTO.getFloor());
        room.setDailyRate(roomsDTO.getDailyRate());
        room.setMaxOccupancy(roomsDTO.getMaxOccupancy());
        return roomsRepository.save(room);
    }

    public Rooms updateRoom(RoomsDTO roomsDTO) {
        Rooms room = roomsRepository.findById(roomsDTO.getRoomNumber())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setRoomType(roomsDTO.getRoomType());
        room.setFloor(roomsDTO.getFloor());
        room.setDailyRate(roomsDTO.getDailyRate());
        room.setMaxOccupancy(roomsDTO.getMaxOccupancy());
        return roomsRepository.save(room);
    }

    public void deleteRoom(Long roomNumber) {
        roomsRepository.deleteById(roomNumber);
    }

    public Rooms getRoomById(Long roomNumber) {
        return roomsRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public List<Rooms> getAllRooms() {
        return roomsRepository.findAll();
    }
}
