package com.bookambulance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.bookambulance.GraphQlModels.locationQl;
import com.bookambulance.Model.Location;
import com.bookambulance.Services.LocationServices;
@Controller
public class LocationController {
    @Autowired private LocationServices locationServices;
    @MutationMapping()
    public Location saveLocation(@Argument(name = "input") locationQl locationQl){
        return locationServices.saveOrUpdateData(locationQl.locationData());
    }
}
