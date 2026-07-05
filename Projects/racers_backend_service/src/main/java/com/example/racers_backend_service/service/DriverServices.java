package com.example.racers_backend_service.service;

import com.example.racers_backend_service.entity.Drivers;
import com.example.racers_backend_service.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.racers_backend_service.entity.Drivers;
import java.util.List;

@Service
public class DriverServices {
    @Autowired
    private DriverRepository  repository;

    public List<Drivers> getAllDrivers(){
        return repository.findAll();
    }

    public Drivers saveDriver(Drivers driver) {
        return repository.save(driver);
    }
    public void deleteDriver(Integer id){
        repository.deleteById(id);
    }
    public Drivers updateDriver(Integer id, Drivers updatedDriverDetails) {
        Drivers existingDriver = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
        existingDriver.setName(updatedDriverDetails.getName());
        return repository.save(existingDriver);
    }
}
