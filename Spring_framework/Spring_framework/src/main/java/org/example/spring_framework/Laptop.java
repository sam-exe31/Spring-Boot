package org.example.spring_framework;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//we  can put it in case of confusion
public class Laptop implements Computer {

    public void start(){
        System.out.println("Starting laptop ");

    }
}
