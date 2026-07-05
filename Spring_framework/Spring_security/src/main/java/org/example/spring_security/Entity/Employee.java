package org.example.spring_security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {


    @Id
    private int id;
    private String empName;
    private String password;

    public Employee(int id, String empName, String password) {
        this.id = id;
        this.empName = empName;
        this.password = password;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", emp_name='" + empName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_name() {
        return empName;
    }

    public void setEmp_name(String empname) {
        this.empName = empname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
