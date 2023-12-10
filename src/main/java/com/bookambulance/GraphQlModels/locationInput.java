package com.bookambulance.GraphQlModels;
import com.bookambulance.Model.Location;
import com.bookambulance.Services.LocationServices;

import lombok.Data;

@Data
public class locationInput {
private String name;
private String type;
private long locationFk;
public Location locationData(){
    return new Location(this.name,this.type,this.findById());
}
private Location findById()
{ try {
    System.out.println(locationFk);
    LocationServices locationServices=new LocationServices();
   return locationServices.findById(locationFk); 
} catch (Exception e) {
    System.out.println("No found"+locationFk);
    System.out.println(e.getMessage());
    return null;
}}
}

