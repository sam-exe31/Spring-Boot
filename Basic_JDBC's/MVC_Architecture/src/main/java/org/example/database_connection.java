package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database_connection {


    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Driver is registered");
    }

    public static Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/learn_jdbc";
            String user="root";
            String password="mysql";
            return DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeResources(Connection connect, Statement statement) throws SQLException {
        if(connect!=null){
            connect.close();
        }
        if(statement!=null){
            statement.close();
        }
    }
}
