package org.example.workers_backend_services.Service;

import org.example.workers_backend_services.Entity.Users;
import org.example.workers_backend_services.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository repository;


    public List<Users> getallusers() {
        return repository.findAll();
    }

    public Users getuserbyid(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public Users adduser(Users user) {
        if(user.getCreated_at()==null){
            user.setCreated_at(LocalDateTime.now());
        }
        return repository.save(user);
    }

    public Users updateusers(Long id, Users users) {
        Users request=repository.findById(id).orElseThrow(null);
        request.setUser_name(users.getUser_name());
        request.setEmail(users.getEmail());
        request.setPhone(users.getPhone());
        request.setPassword(users.getPassword());
        request.setRole(users.getRole());


        return repository.save(request);
    }

    public boolean deleteuser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
