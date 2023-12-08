package com.bookambulance.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private long id;
private String name;
private String gender;
private String phoneNumber;
private String email;
private String password;
private String role;
}
