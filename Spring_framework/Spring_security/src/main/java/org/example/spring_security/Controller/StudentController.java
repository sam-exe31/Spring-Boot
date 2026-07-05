package org.example.spring_security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.spring_security.Entity.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> studentList = new ArrayList<>(List.of(new Student(1, "sam", 90), new Student(
            2, "radha", 70), new Student(3, "saru", 85)));

    @GetMapping("/Student")
    public List<Student> getallStudnets(){
        return studentList;
    }

    @GetMapping("/Csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/Student")
    public List<Student> poststudent(@RequestBody Student student){
//        studentList.addAll(student);
//        return studentList;
        studentList.add(student);
        return studentList;
    }

}