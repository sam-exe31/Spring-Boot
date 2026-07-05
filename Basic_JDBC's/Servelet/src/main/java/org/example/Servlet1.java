package org.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("welcome sam");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Servlet 1 running...");
        String username = req.getParameter("uname");
        String city = req.getParameter("ucity");


        HttpSession session = req.getSession();
        session.setAttribute("name", username);
        session.setAttribute("userCity", city);


        PrintWriter writer = res.getWriter();
        writer.println("<h1>this is the time to make changes</h1>");


        RequestDispatcher reqDispatcher = req.getRequestDispatcher("/Servlet2");


        reqDispatcher.include(req, res);


        writer.close();
        System.out.println("closed first");
    }
}
