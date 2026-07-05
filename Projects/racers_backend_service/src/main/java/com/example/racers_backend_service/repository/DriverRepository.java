package com.example.racers_backend_service.repository;

import com.example.racers_backend_service.entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends JpaRepository<Drivers,Integer> {
}
