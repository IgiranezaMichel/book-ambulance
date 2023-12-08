package com.bookambulance.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookambulance.Interfaces.DataInterface;
import com.bookambulance.Model.Hospital;
import com.bookambulance.Repository.HospitalRepository;

public class HospitalServices implements DataInterface<Hospital>{
    @Autowired private HospitalRepository hospitalRepository;
    @Override
    public Hospital saveOrUpdateData(Hospital data) {
        return hospitalRepository.save(data);
    }

    @Override
    public void deleteDataById(Hospital id) {
       hospitalRepository.delete(id);
    }

    @Override
    public List<Hospital> getAllData() {
       return hospitalRepository.findAll();
    }

}
