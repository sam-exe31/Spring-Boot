package org.example; // Kept in your package structure

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;  // Added HTTP Specific import
import jakarta.servlet.http.HttpServletResponse; // Added HTTP Specific import
import jakarta.servlet.http.HttpSession;        // Added to read sessions

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    // FIX: Changed parameters to HTTP specific versions here too
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("servlet 2 running...");
        PrintWriter writer = res.getWriter();
        writer.println("<h1>this is the 2nd Servlet</h1>");

        HttpSession session = req.getSession();

        String storedName = (String) session.getAttribute("name");
        String storedCity = (String) session.getAttribute("userCity");

        // 3. Print the session values on the screen
        if (storedName != null) {
            writer.println("<p>Session Data Received! Welcome back, " + storedName + " from " + storedCity + "</p>");
        } else {
            writer.println("<p>No session data found.</p>");
        }


        System.out.println("Completed 2nd processing step");
    }
}