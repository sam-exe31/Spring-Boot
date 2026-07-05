package org.example;

public class Student
{

//    private Laptop laptop;
//    private int age;
//    public Student() {
//        System.out.println("constructor student");
//    }
//
//    public Student(Laptop laptop) {
//        this.laptop=laptop;
//        System.out.println("this is age consrtuctor");
//    }
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    Computer computer;
    public Student(Computer computer){
        this.computer=computer;
        System.out.println("make things better by computer ");
    }

    public void Build(){
        System.out.println("hello injected this");

    }
}
