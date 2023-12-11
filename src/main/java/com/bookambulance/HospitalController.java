package com.bookambulance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.bookambulance.GraphQlModels.HospitalInput;
import com.bookambulance.Model.Hospital;
import com.bookambulance.Services.HospitalServices;

@Controller
public class HospitalController {
@Autowired private HospitalServices hospitalServices;
@MutationMapping() public Hospital addHospital(@Argument(name = "input")HospitalInput HospitalInput)
{return hospitalServices.saveOrUpdateData(HospitalInput);}
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
}
