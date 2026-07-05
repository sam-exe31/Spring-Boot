package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        //this line crates container
//        Student student=context.getBean(Student.class);
//        Student student;
//        student.Build();
        Student stu= context.getBean(Student.class);
//        stu.setAge(34);
//        System.out.println(stu.getAge());
//        System.out.println(stu.getLaptop());

    }

}
