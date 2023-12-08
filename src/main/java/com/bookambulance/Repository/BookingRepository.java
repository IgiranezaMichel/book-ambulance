package com.bookambulance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookambulance.Model.Booking;
public interface BookingRepository extends JpaRepository<Booking,Long>{

}
