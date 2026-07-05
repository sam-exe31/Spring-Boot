package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class Register extends HttpServlet {


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name=req.getParameter("uname");
        String food=req.getParameter("ufood");
        String city=req.getParameter("ucity");
        String age =req.getParameter("uage");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/learn_jdbc";
            String user="root";
            String password="mysql";

            Connection connect= DriverManager.getConnection(url,user,password);

            PreparedStatement pstmt=connect.prepareStatement("Insert into register values(?,?,?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setString(3,age);
            pstmt.setString(4,food);

            int rowsaffected=pstmt.executeUpdate();
            PrintWriter writer=res.getWriter();
            if(rowsaffected==0){

                writer.println("<h1>NO chnages made<h1/>");
            }
            else {
                writer.println("<h2>changes made succesfully </h2>");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
