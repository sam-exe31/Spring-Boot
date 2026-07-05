package org.example.spring_framework;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {

    public void start(){
        System.out.println("Starting laptop ");

    }
}
