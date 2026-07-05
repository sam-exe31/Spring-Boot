package org.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/dynamicresp")
public class dynamicresp extends HttpServlet {

    public dynamicresp() {
        System.out.println("made a good resp ");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("welcome radha");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String password=req.getParameter("password");

        PrintWriter writer=resp.getWriter();


        if(name.equals("sam") && password.equals("123")){
//            writer.println("enter well");
//            writer.println("welcome "+name);
//            writer.println("you entered  the thing");

            req.setAttribute("username",name);
            req.setAttribute("password",password);
            RequestDispatcher dispatcher =req.getRequestDispatcher("/sucess.jsp");
            dispatcher.forward(req,resp);
            resp.sendRedirect("/Servelet/sucess.jsp");
        }
        else{
//            writer.println("failed");
            resp.sendRedirect("/response.html");
//            resp.setContentType("text/html");
//            resp.getWriter().println("<h3 style='color:red; text-align:center;'>Authentication Failed! Incorrect username or password.</h3>");
//            resp.getWriter().println("<p style='text-align:center;'><a href='index.html'>Try Again</a></p>");
        }


        writer.close();
    }
}
