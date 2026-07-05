package org.example.spring_web_1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
        public String login(){
        System.out.println("this is requested login");
        return "Login oage";
        }
}
