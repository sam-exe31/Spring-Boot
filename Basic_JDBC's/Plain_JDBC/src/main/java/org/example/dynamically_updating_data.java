package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dynamically_updating_data {
    public static void main(String[] args) {
        Connection connection =null;
        PreparedStatement statement=null;
        Scanner scan=new Scanner(System.in);
        try {
                connection = jbc_learning.getConnection();
                String query = "update students set name=? where student_id=?";
                statement=connection.prepareStatement(query);

                System.out.println("enter details here");
                System.out.println("enter the name of the query");
                String name = scan.next();
                System.out.println("enter the id ");
                int id = scan.nextInt();
                statement.setString(1,name);
                statement.setInt(2,id);

                int rowaffected=statement.executeUpdate();
                if(rowaffected==0){
                    System.out.println("not executed query");
                }
                else{
                    System.out.println("executed succesfully");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                jbc_learning.closeConnection(connection,statement);
            } catch (SQLException e)
            {
                System.out.println("last la aal re bhai");
                throw new RuntimeException(e);
            }
        }
    }
}
