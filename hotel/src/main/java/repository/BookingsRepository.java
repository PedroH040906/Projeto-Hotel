package repository;

import domain.Bookings;
import domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findAllByRoom_Type(RoomType roomType);
}
