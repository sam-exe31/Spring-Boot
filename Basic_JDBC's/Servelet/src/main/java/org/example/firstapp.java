package org.example;
import jakarta.servlet.*;

import com.sun.net.httpserver.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstServlet")
public class firstapp extends HttpServlet {
    public firstapp(){
        System.out.println("servlet object is created ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("uname");
        String city=req.getParameter("ucity");
        String age =req.getParameter("uage");

        PrintWriter writer=resp.getWriter();

        writer.println("hello"+name+"from"+city);
        writer.println("your age is "+age);

        writer.close();

    }
}
