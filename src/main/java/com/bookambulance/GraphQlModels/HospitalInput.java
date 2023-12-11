package com.bookambulance.GraphQlModels;

import com.bookambulance.Model.Hospital;

import lombok.*;
public class HospitalInput extends Hospital{
@Getter @Setter
private String locationId;
}
