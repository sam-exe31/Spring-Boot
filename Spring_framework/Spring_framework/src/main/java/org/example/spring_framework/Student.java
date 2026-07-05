package org.example.spring_framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student
{
    @Autowired
    @Qualifier("laptop")
    private Computer computer;

//    public Student(Laptop laptop){
//        this.laptop=laptop;
//    }// constructor injection

//    public void  setStudent(Laptop laptop){
//        this.laptop=laptop;
//    }// for setter injection we have to use autowired

    public void Build(){
        System.out.println("hello injected this");
        computer.start();
    }
}
