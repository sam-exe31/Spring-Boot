package com.example.racers_backend_service.controller;


import com.example.racers_backend_service.entity.Circuits;
import com.example.racers_backend_service.service.CircuitsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/circuits")
@CrossOrigin
public class CircuitsController {
    @Autowired
    private CircuitsServices services;

    @GetMapping
    public List<Circuits> getCircuits(){
        return services.getAllCircuits();
    }

    @PostMapping
    public Circuits addCircuit(@RequestBody Circuits circuit){
        return services.saveCircuit(circuit);
    }

}
