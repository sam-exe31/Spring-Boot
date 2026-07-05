package com.example.racers_backend_service.repository;

import com.example.racers_backend_service.entity.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor,Integer> {

}
