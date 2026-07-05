package org.example;

import java.sql.*;

public class LaunchApp1 {

    static void main(String[] args) throws ClassNotFoundException, SQLException {
        // load and register JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");

        //establish connecttion
        String url="jdbc:mysql://localhost:3306/learn_jdbc";
        String user="root";
        String password="mysql";
        Connection connnect =DriverManager.getConnection(url,user,password);

        Statement statement = connnect.createStatement();

        // insert and update
        //execute query
            String sql="Insert into students values (2,'radha','samesu@gmail.com','9767538550',19)";
            String update="update students set name='sonu' where student_id=2";
        int rowaffected=statement.executeUpdate(update);
        // it will return the number of rows affected
        //process result
        if(rowaffected==0){
            System.out.println("unable to change data");
        }
        statement.close();
        connnect.close();
    }
}
