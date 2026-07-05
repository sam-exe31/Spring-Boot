package com.example.racers_backend_service.service;

import com.example.racers_backend_service.entity.Race;
import com.example.racers_backend_service.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServices {
    @Autowired
    private RaceRepository Repository;

    public List<Race> getAllRaces(){
        return Repository.findAll();
    }

    public Race saveRace(Race race) {
        return Repository.save(race);
    }
}
