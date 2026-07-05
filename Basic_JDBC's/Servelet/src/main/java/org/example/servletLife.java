package org.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/servletLife")
public class servletLife extends HttpServlet {

    static {
        System.out.println("which loads first heer");
    }
    public  servletLife(){
        System.out.println("Started here also han ");
    }
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        System.out.println("initialize servlet");
//    }

//    @Override
//    public void destroy() {
//        System.out.println("byeee ddestory");
//    }

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println("service method to get and respond to the request");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String age=req.getParameter("age");
        String password=req.getParameter("password");

        PrintWriter writer=resp.getWriter();

        if(name.equals("sam") && password.equals("123")){
            writer.println("perfect match");
            System.out.println("loggen in ");
        }
        else{
            writer.println("something is missing here");
            System.out.println("fuck off");
        }
        writer.close();
    }
}
