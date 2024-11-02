package controller;

import domain.Rooms;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.RoomsDTO;
import service.RoomsService;

import java.util.List;

@Controller
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomsController {

    private final RoomsService roomsService;

    // Endpoint para listar todos os quartos
    @GetMapping
    public ResponseEntity<List<Rooms>> getAllRooms() {
        List<Rooms> rooms = roomsService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    // Endpoint para obter um quarto específico pelo número do quarto
    @GetMapping("/{roomNumber}")
    public ResponseEntity<Rooms> getRoomById(@PathVariable Long roomNumber) {
        Rooms room = roomsService.getRoomById(roomNumber);
        return ResponseEntity.ok(room);
    }

    // Endpoint para adicionar um novo quarto
    @PostMapping
    public ResponseEntity<Rooms> addRoom(@RequestBody RoomsDTO roomsDTO) {
        Rooms room = roomsService.addRoom(roomsDTO);
        return ResponseEntity.ok(room);
    }

    // Endpoint para atualizar um quarto existente
    @PutMapping("/{roomNumber}")
    public ResponseEntity<Rooms> updateRoom(@PathVariable Long roomNumber, @RequestBody RoomsDTO roomsDTO) {
        roomsDTO.setRoomNumber(roomNumber);
        Rooms updatedRoom = roomsService.updateRoom(roomsDTO);
        return ResponseEntity.ok(updatedRoom);
    }

    // Endpoint para deletar um quarto
    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomNumber) {
        roomsService.deleteRoom(roomNumber);
        return ResponseEntity.noContent().build();
    }
}
