package org.example.spring_jdbc;

import org.example.spring_jdbc.Model.Student;
import org.example.spring_jdbc.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(SpringJdbcApplication.class, args);
       Student student=context.getBean(Student.class);
       student.setId(107);
       student.setName("radha");
       student.setFeild("computer");

        StudentRepository studentRepository=context.getBean(StudentRepository.class);
        studentRepository.save(student);
        System.out.println(studentRepository.findAll());
    }

}
