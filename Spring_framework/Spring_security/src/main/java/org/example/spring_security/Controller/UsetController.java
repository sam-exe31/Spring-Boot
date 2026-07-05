package org.example.spring_security.Controller;

import org.example.spring_security.Entity.Users;
import org.example.spring_security.Services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsetController {

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return userDetailService.register(users);
    }

    @PostMapping("/login")
    public String login (@RequestBody Users user){
        System.out.println(user);
        return userDetailService.verify(user);
    }
}
