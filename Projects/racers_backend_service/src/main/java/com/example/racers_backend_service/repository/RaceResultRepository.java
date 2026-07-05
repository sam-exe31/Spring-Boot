package com.example.racers_backend_service.repository;

import com.example.racers_backend_service.entity.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult,Integer> {
}
