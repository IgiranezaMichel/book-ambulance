package com.bookambulance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.bookambulance.GraphQlModels.HospitalInput;
import com.bookambulance.Model.Hospital;
import com.bookambulance.Services.HospitalServices;
import com.bookambulance.Services.LocationServices;

@Controller
public class HospitalController {
@Autowired private HospitalServices hospitalServices;
@Autowired private LocationServices locationServices;
@MutationMapping() public Hospital addHospital(@Argument(name = "input")HospitalInput HospitalInput)
{   HospitalInput.setLocation(locationServices.findById(Long.parseLong(HospitalInput.getLocationId())));
    return hospitalServices.saveOrUpdateData(new Hospital(HospitalInput.getId(),HospitalInput.getName(),HospitalInput.getLocation()));
}

@MutationMapping() public String deleHospital(@Argument long id){
    Hospital hospital=hospitalServices.findById(id);
    if(!(hospital==null)){
        hospitalServices.deleteDataById(hospital.getId());
        return hospital.getName() +" Deleted successfully";
    }
    else{
        return "Hospital not found";
    }
}
@QueryMapping() public  Hospital getHospitalById(@Argument long id)
{
    return hospitalServices.findById(id);
}
@QueryMapping() public List<Hospital> getAllHospital()
{
    return hospitalServices.getAllData();
}
}
