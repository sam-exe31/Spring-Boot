package org.example.workers_backend_services.Controller;

import org.example.workers_backend_services.Entity.Users;
import org.example.workers_backend_services.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping  // all
    public ResponseEntity<List<Users>> getallUsers(){
        List<Users> use=userServices.getallusers();
        return ResponseEntity.ok(use);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserbyid( @PathVariable  Long id){
        Users use= userServices.getuserbyid(id);
        if(use!=null){
            return ResponseEntity.ok(use);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Users> adduser(@RequestBody Users user){
        Users createduser=userServices.adduser(user);
        return new ResponseEntity<>(createduser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateusers(@PathVariable Long id,@RequestBody Users users){
        Users updateduser=userServices.updateusers(id,users);
        if(updateduser!=null){
            return ResponseEntity.ok(updateduser);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteuser(@PathVariable Long id){
        userServices.deleteuser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
