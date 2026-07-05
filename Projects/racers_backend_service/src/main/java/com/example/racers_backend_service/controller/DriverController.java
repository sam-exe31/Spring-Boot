package com.example.racers_backend_service.controller;


import com.example.racers_backend_service.entity.Drivers;
import com.example.racers_backend_service.service.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Driver;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverServices services;

    @GetMapping
    public List<Drivers> getDrivers(){
        return services.getAllDrivers();
    }
    @PostMapping
    public Drivers addDriver(@RequestBody Drivers driver) {
        return services.saveDriver(driver);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") Integer id){
        services.deleteDriver(id);
    }

    @PutMapping("/{id}")
    public Drivers updateDriver(@PathVariable Integer id, @RequestBody Drivers updatedDriverDetails) {
        return services.updateDriver(id, updatedDriverDetails);
    }
}
