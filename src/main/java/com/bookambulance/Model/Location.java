package com.bookambulance.Model;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Location {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private long id;
private String name;
private String type;
@ManyToOne
private Location location;
@OneToMany(mappedBy = "location")
private List<Hospital>hospitalLocation;
@OneToMany(mappedBy = "location")
private List<Location>locationList;
}
