package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jbc_learning {
    static  {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {

        String url="jdbc:mysql://localhost:3306/learn_jdbc";
        String user="root";
        String password= "mysql";

        return  DriverManager.getConnection(url,user,password);

    }
    public static  void closeConnection (Connection connect , Statement statement) throws SQLException {
        connect.close();
        statement.close();
    }

}
