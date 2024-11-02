package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rooms")
public class Rooms {

    @Id
    @Column(name = "room_number")
    private Long roomNumber;

    @Column(name = "room_type")
    private RoomType roomType;

    @Column(name = "daily_rate")
    private BigDecimal dailyRate;

    @Column(name = "max_occupancy")
    private int maxOccupancy;

    @Column(name = "is_available")
    private boolean isAvailable = true;

    @Column(name = "beds")
    private int beds;

    @Column(name = "floor")
    private int floor;

}
