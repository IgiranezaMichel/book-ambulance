package com.bookambulance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bookambulance.GraphQlModels.locationInput;
import com.bookambulance.Model.Location;
import com.bookambulance.Services.LocationServices;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class LocationController {
    @Autowired private LocationServices locationServices;
    @MutationMapping() public Location addLocation(@Argument(name = "input") locationInput locationQl){
        Location location=new Location(); 
        try {
            if(!(locationQl.getLocationFk()==Long.parseLong("0")))
            location=locationServices.findById(locationQl.getLocationFk());
            if(!locationQl.equals(""))
            {
                return new Location(Long.parseLong(locationQl.getId()), locationQl.getName(), locationQl.getType(), location, null, null);
            }
         } catch (Exception e) {
            log.error(e.getMessage());
         }
        return locationServices.saveOrUpdateData(new Location(locationQl.getName(), locationQl.getType(), location));
    }
    @MutationMapping() public String deleteLocation(@Argument String id)
    {
        try {
            if(!id.equals(""))
            {
                Location location=locationServices.findById(Long.parseLong(id));
                if(!(location==null)){
                    locationServices.deleteDataById(Long.parseLong(id));
                    log.info(location.getName()+" has been removed successfully");
                    return location.getName() +" Deleted successfully";
                }
                else return "Location not found";
            }
            else return "specify Location please";
        } catch (Exception e) {
            log.info("Error happen=>"+e.getMessage());
           return "Location doesn't exist";
        }
    }
    @QueryMapping() public Location findLocationById(@Argument String id)
    {   try {
        return locationServices.findById(Long.parseLong(id));
    } catch (Exception e) {
        return null;
    }
    }
    
        
}
