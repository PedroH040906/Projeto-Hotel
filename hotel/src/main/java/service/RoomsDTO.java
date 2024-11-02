package service;

import domain.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomsDTO {

    private Long roomNumber;

    private RoomType roomType;

    private BigDecimal dailyRate;

    private int maxOccupancy;

    private boolean isAvailable;

    private int beds;

    private int floor;
}
