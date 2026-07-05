package com.example.racers_backend_service.controller;

import com.example.racers_backend_service.entity.RaceResult;
import com.example.racers_backend_service.service.RaceResultServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@CrossOrigin

public class RaceResultController {
    @Autowired
    private RaceResultServices services;

    @GetMapping
    public List<RaceResult> getResults(){
        return services.getAllRaceResults();
    }
}
