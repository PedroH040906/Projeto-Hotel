package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bookings")
public class Bookings {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    @OneToMany
    private Customers customer;

    @Column(name = "room_id")
    @OneToMany
    private Rooms room;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "number_people")
    private int numberPeople;

}
