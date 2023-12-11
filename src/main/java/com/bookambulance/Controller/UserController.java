package com.bookambulance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.bookambulance.GraphQlModels.userInput;
import com.bookambulance.Model.User;
import com.bookambulance.Services.UserServices;

@Controller
public class UserController {
@Autowired private UserServices userServices;
@MutationMapping() public User addUser(@Argument(name = "input") userInput userinput)
{   
    if(userinput.getIdentity()==null)
      userinput.setIdentity("0");
    return userServices.saveOrUpdateData(new User(Long.parseLong(userinput.getIdentity()), userinput.getName(), userinput.getGender(), userinput.getPhoneNumber(), userinput.getEmail(), userinput.getPassword(), userinput.getRole(), null));
}
@MutationMapping() public String deleteUser(@Argument long id){
  try {
    User user=userServices.findById(id);
    if(user!=null)
       {
        userServices.deleteDataById(user.getId());
        return user.getName()+" Removed Successfully";
      }
      else{
        return "User not found";
      }
  } catch (Exception e) {
    return "Server error";
  }
}
}
