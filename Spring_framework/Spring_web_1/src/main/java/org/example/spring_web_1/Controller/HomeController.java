package org.example.spring_web_1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        System.out.println("welcome to page");
        return "hello sam";
        // it will look for a file hello sam
    }
    @RequestMapping("/about")
    public String about(){
        return "<h1>dont ask about me </h1> ";
    }
}
