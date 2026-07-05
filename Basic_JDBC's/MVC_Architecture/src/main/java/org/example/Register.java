package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Register")
public class Register extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
        String name = req.getParameter("uname");
        String age = req.getParameter("age");
        String city = req.getParameter("ucity");
        String roll = req.getParameter("uroll");
        String password = req.getParameter("upass");

        Model model = new Model();
        model.setName(name);
        model.setAge(age);
        model.setCity(city);
        model.setRoll(roll);
        model.setPassword(password);

        int row = model.register();

        HttpSession session=req.getSession();
        session.setAttribute("name",name);

        //add name and make it final with revsion and making notes of it self and chat gpt
        if (row == 0) {
            res.sendRedirect("/failure.jsp");
        } else {
            res.sendRedirect("/success.jsp");
        }
    } catch (RuntimeException e) {
        res.sendRedirect("/failure.jsp");
    }
    }
}
