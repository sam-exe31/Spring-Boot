package org.example.spring_web_1.Services;

import org.example.spring_web_1.Entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServices {

    private Student student;

    private final Logger logger= LoggerFactory.getLogger(StudentServices.class);

    List <Student> list=new ArrayList<>(Arrays.asList(new Student(101, "samarth", "pune"),
            new Student(102,"Radha","ambajagai"),new Student(103,"sonu","pune")));
    public List<Student> getStudent(){
        return list;
    }

    //get method by ID
    public Student getStudentbyID(int id){
        logger.trace("make things great");
        return list.stream()
                .filter(s->s.getId()==id).
                findFirst()
                .orElse(new Student(105,"sarthak","latur"));
    }

    public Student setStudent(Student student){
        list.add(student);
        return student;
    }

    public Student updateStudent(Student student) {

        return list.stream()
                .filter(s->s.getId()==student.getId()).findFirst().get();
    }

    public Student deleteStudent(int id) {
         Student todelete=list.stream()
                .filter(s->s.getId()==id).findFirst().orElse(null);
         if(todelete!=null){
             list.remove(todelete);
         }
         return todelete;
    }
}
