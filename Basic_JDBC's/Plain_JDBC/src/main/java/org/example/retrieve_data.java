package org.example;

import java.sql.*;

public class retrieve_data {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        //establishing connections
        String url="jdbc:mysql://localhost:3306/learn_jdbc";
        String user="root";
        String password= "mysql";

        Connection connect= DriverManager.getConnection(url,user,password);

        Statement statement= connect.createStatement();

        // fetch data from the table

        String sql ="select * from students";
        ResultSet rs=statement.executeQuery(sql);

        while(rs.next()){
            System.out.println("|"+rs.getInt(1)+"|"+rs.getString("name")+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getInt(5)+"|");
        }

        String delete="delete from students where id=2";
        int res=statement.executeUpdate(delete);
        if(res!=0)System.out.println("executed and deleted ");

        rs.close();
        statement.close();
        connect.close();
    }
}
