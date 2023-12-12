package com.bookambulance.Model;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Booking {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne()
    private User user;
    private LocalDateTime bookingDate=LocalDateTime.now();
}
