package org.example.spring_web_1.Controller;

import org.example.spring_web_1.Entity.Student;
import org.example.spring_web_1.Services.StudentServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
public class StudentController {
//    private static final Logger logger= LogManager.getLogger(StudentController.class);
    private static final Logger log= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentServices studentServices;
    @RequestMapping("/student")
//    public List<Student> getStudents(){
//        log.info("request is in api student");
//        return studentServices.getStudent();
//    }
    public String getStudent(){
        log.debug("called get api on students  enabled debug method");
        // in spring boot we have like only  methods like info,warn,error if we wanna display other methods we need to like enable it
        return "hello iss";
    }

    @RequestMapping("/student/{id}")
    public Student getstudentbyid(@PathVariable  int id){
        System.out.println(studentServices.getStudent());
        return studentServices.getStudentbyID(id);
    }

    @PostMapping("/student")
    public Student setstudent(@RequestBody Student student){
        return studentServices.setStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return studentServices.updateStudent(student);
    }
    @DeleteMapping("/student/{id}")
    public Student deleteStudnet(@PathVariable int id){
        return studentServices.deleteStudent(id);
    }
}
