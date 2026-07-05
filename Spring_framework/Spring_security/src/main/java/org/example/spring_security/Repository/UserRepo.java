package org.example.spring_security.Repository;

import org.example.spring_security.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<Users,Integer>{

    Users findByName(String name);

}
