package com.bookambulance.Model;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Booking {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne()
    private User user;
    private Date bookingDate;
}
