package com.bookambulance.GraphQlModels;
import com.bookambulance.Model.Location;
import lombok.Data;

@Data
public class locationQl {
private String name;
private String type;
public Location locationData(){
    return new Location(this.name,this.type);
}
}

