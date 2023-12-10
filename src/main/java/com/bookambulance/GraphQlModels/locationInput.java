package com.bookambulance.GraphQlModels;
import com.bookambulance.Model.Location;
import lombok.Data;

@Data
public class locationInput {
private Location location;
public locationInput(Location location){
    this.location=location;
}
private String name;
private String type;
public Location locationData(){
    return new Location(this.name,this.type,this.location);
}

}

