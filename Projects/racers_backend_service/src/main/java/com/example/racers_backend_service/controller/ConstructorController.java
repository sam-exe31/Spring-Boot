package com.example.racers_backend_service.controller;

import com.example.racers_backend_service.entity.Constructor;
import com.example.racers_backend_service.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/constructors")
@CrossOrigin
public class ConstructorController {

    @Autowired
    private ConstructorService service;

    @GetMapping
    public List<Constructor> getConstructors() {
        return service.getAllConstructors();
    }


}
