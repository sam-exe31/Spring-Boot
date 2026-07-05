package org.example;

import java.sql.*;

public class Delete_data {
    static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=null;
        Statement statement=null;

        try{
            connection = jbc_learning.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        statement=connection.createStatement();
        try {
            String sql = "delete from students where student_id=2";
            statement.executeUpdate(sql);
            System.out.println("record deleted sucessfully");
        } catch (SQLException e) {
            System.out.println("error it is ");
        }

        String sql="select * from students";
        boolean status= statement.execute(sql);

        if(status){
            System.out.println("IF block");
            ResultSet rs=statement.getResultSet();
            while(rs.next()){
                System.out.println("|"+rs.getInt(1)+"|"+rs.getString("name")+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getInt(5)+"|");
            }
        }
        else{
            System.out.println("else block");
            int rows=statement.getUpdateCount();
            if(rows==0) System.out.println("Operation failed");
            else System.out.println("Operation successful");
        }

        try{
            jbc_learning.closeConnection(connection,statement);
            System.out.println("this is executed");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
