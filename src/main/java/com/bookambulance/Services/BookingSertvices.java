package com.bookambulance.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.bookambulance.Interfaces.DataInterface;
import com.bookambulance.Model.Booking;
import com.bookambulance.Repository.BookingRepository;

public class BookingSertvices implements DataInterface<Booking>{
    @Autowired private BookingRepository bookingRepo;
    @Override
    public Booking saveOrUpdateData(Booking data) {
       return bookingRepo.save(data);
    }

    @Override
    public List<Booking> getAllData() {
       return bookingRepo.findAll();
    }

    @Override
    public void deleteDataById(Booking id) {
     bookingRepo.delete(id);
    }

}
