package com.bookambulance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bookambulance.GraphQlModels.locationInput;
import com.bookambulance.Model.Location;
import com.bookambulance.Services.LocationServices;
@Controller
public class LocationController {
    @Autowired private LocationServices locationServices;
    @MutationMapping()
    public Location addLocation(@Argument(name = "input") locationInput locationQl){
        return locationServices.saveOrUpdateData(locationQl.locationData());
    }
    @QueryMapping()
    public Location findLocationById(@Argument String id)
    {   System.out.println(id);
        return locationServices.findById(Long.parseLong(id));}
}
