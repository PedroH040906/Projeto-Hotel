package service;

import domain.Bookings;
import domain.RoomType;
import domain.Rooms;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.BookingsRepository;
import repository.RoomsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingsService {

    private final BookingsRepository bookingsRepository;
    private final RoomsRepository roomsRepository;

    public void checkIn(BookingsDTO bookingsDTO) {
        Rooms room = bookingsDTO.getRoom();
        if (!room.isAvailable()) {
            throw new IllegalStateException("Room is not available for check-in.");
        }

        Bookings bookings = new Bookings();
        bookings.setCheckInDate(bookingsDTO.getCheckInDate());
        bookings.setNumberPeople(bookingsDTO.getNumberPeople());
        bookings.setCustomer(bookingsDTO.getCustomer());
        bookings.setRoom(room);


        room.setAvailable(false);
        roomsRepository.save(room);
        bookingsRepository.save(bookings);
    }

    public void checkOut(BookingsDTO bookingsDTO) {
        Bookings bookings = bookingsRepository.findById(bookingsDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        bookings.setCheckOutDate(bookingsDTO.getCheckOutDate());

        Rooms room = bookings.getRoom();
        room.setAvailable(true);

        roomsRepository.save(room);
        bookingsRepository.save(bookings);
    }

    public List<Bookings> getAllBookings() {
        return bookingsRepository.findAll();
    }

    public Bookings getBookingById(Long id) {
        return bookingsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Booking not found"));
    }

    public List<Bookings> getBookingsByType(RoomType roomType) {
        return bookingsRepository.findAllByRoom_Type(roomType);
    }
}
