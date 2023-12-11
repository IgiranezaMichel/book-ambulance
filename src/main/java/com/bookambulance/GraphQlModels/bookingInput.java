package com.bookambulance.GraphQlModels;

import com.bookambulance.Model.Booking;

import lombok.Getter;
import lombok.Setter;

public class bookingInput extends Booking{
    @Getter @Setter
    private Long userId;
}
