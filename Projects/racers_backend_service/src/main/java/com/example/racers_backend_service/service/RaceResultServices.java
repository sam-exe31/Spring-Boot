package com.example.racers_backend_service.service;

import com.example.racers_backend_service.entity.RaceResult;
import com.example.racers_backend_service.repository.RaceRepository;
import com.example.racers_backend_service.repository.RaceResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceResultServices {
    @Autowired
    private RaceResultRepository result;

    public List<RaceResult> getAllRaceResults(){
        return  result.findAll();
    }
}
