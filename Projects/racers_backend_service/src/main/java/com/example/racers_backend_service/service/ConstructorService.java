package com.example.racers_backend_service.service;

import com.example.racers_backend_service.entity.Constructor;
import com.example.racers_backend_service.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructorService {
    @Autowired
    private ConstructorRepository repository;

    public List<Constructor> getAllConstructors(){
        return repository.findAll();
        
    }

}
