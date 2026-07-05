package org.example.oauth2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DEmoController {

    @GetMapping("/")
    public String greet(){
        return "hello controller";
    }
}
