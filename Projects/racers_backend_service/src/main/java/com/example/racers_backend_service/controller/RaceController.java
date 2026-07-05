package com.example.racers_backend_service.controller;


import com.example.racers_backend_service.entity.Race;
import com.example.racers_backend_service.service.RaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/races")
@CrossOrigin
@RestController
public class RaceController {
    @Autowired
    private RaceServices service;

    @GetMapping
    public List<Race> getRaces() {
        return service.getAllRaces();
    }
    @PostMapping
    public Race addRace(@RequestBody Race race) {
        return service.saveRace(race);
    }
}
