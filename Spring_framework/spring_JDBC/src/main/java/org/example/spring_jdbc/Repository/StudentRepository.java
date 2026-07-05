package org.example.spring_jdbc.Repository;

import org.example.spring_jdbc.Model.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate template;


    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student student){
        System.out.println("added");
        String sql="Insert into student values(?,?,?)";
        int rows=template.update(sql,student.getId(),student.getName(),student.getFeild());
        System.out.println("rows affected "+rows);
    }
    public List<Student> findAll(){
        String sql="select * from student";
        RowMapper <Student> mapper=new RowMapper<Student>() {
            // it does it like it maps rows multiple times if 4 rows then it will execute 4 times and 1 object at a time
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s=new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setFeild(rs.getString(3));

                return s;
            }
            //mapper can be used as lambda expression

//            RowMapper<Student> mapper=(rs,row)->{
//                Student s=new Student();
//                s.setId(rs.getInt(1));
//                s.setName(rs.getString(2));
//                s.setFeild(rs.getString(3));
//
//                return s;
//            };
        };
        List<Student> list_of_student=template.query(sql,mapper);
        // rowmapper will get us rows one by one

            return list_of_student;
    }

}
