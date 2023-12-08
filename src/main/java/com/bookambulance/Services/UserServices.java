package com.bookambulance.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookambulance.Interfaces.DataInterface;
import com.bookambulance.Model.User;
import com.bookambulance.Repository.UserRepository;

@Service
public class UserServices implements DataInterface<User>{
@Autowired private UserRepository userRepository;

@Override
public User saveOrUpdateData(User data) {
   return userRepository.save(data);
}

@Override
public void deleteDataById(User id) {
   userRepository.delete(id);
}

@Override
public List<User> getAllData() {
   return userRepository.findAll();
}
}
