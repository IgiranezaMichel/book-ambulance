package com.bookambulance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.bookambulance.GraphQlModels.bookingInput;
import com.bookambulance.Model.Booking;
import com.bookambulance.Model.User;
import com.bookambulance.Services.BookingServices;
import com.bookambulance.Services.UserServices;

@Controller
public class BookingController {
@Autowired private BookingServices bookingServices;
@Autowired private UserServices userServices;
@MutationMapping()
private Booking addOrUpdateBooking(@Argument(name="input")bookingInput bookingInput){
    User user=userServices.findById(bookingInput.getUserId());
    if(user==null) return new Booking();
    return bookingServices.saveOrUpdateData(new Booking(0, user, bookingInput.getBookingDate()));
}
}
