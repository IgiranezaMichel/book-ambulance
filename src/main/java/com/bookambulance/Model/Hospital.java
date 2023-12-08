package com.bookambulance.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Hospital {
@Id  @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
@ManyToOne()
private Location location;
}
