package controller;

import domain.Bookings;
import domain.RoomType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BookingsDTO;
import service.BookingsService;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingsController {

    private final BookingsService bookingsService;

    @PostMapping("/checkin")
    public ResponseEntity<String> checkIn(@RequestBody BookingsDTO bookingsDTO) {
        try {
            bookingsService.checkIn(bookingsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Check-in successful.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkOut(@RequestBody BookingsDTO bookingsDTO) {
        try {
            bookingsService.checkOut(bookingsDTO);
            return ResponseEntity.ok("Check-out successful.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Bookings>> getAllBookings() {
        List<Bookings> bookings = bookingsService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable Long id) {
        Bookings booking = bookingsService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/type/{roomType}")
    public ResponseEntity<List<Bookings>> getBookingsByType(@PathVariable RoomType roomType) {
        List<Bookings> bookings = bookingsService.getBookingsByType(roomType);
        return ResponseEntity.ok(bookings);
    }
}
