package com.example.racers_backend_service.service;

import com.example.racers_backend_service.entity.Circuits;
import com.example.racers_backend_service.repository.CircuitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitsServices {
    @Autowired
    private CircuitsRepository repository;

    public List<Circuits> getAllCircuits(){
        return repository.findAll();
    }

    public Circuits saveCircuit(Circuits circuit){
        return repository.save(circuit);
    }

}
