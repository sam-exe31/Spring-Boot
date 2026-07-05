package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {

    private String name;
    private String age;
    private String city;
    private String roll;
    private String password;
    private Connection connect=null;
    private PreparedStatement statement=null;
    private int no_of_rows=0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int register(){
        try{
            connect=database_connection.getConnection();
            String sql="insert into mvc values(?,?,?,?,?)";
            statement=connect.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,age);
            statement.setString(3,city);
            statement.setString(4,roll);
            statement.setString(5,password);

            no_of_rows=statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return no_of_rows;
    }
}
