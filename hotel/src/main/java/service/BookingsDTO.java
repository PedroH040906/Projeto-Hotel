package service;

import domain.Customers;
import domain.Rooms;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingsDTO {

    private Long id;

    private Customers customer;

    private Rooms room;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int numberPeople;
}
