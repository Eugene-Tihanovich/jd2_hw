package it.academy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "FormServlet", urlPatterns = "/user")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("user.name");
        String phoneNumber = req.getParameter("user.phoneNumber");
        String email = req.getParameter("user.email");

        writer.println("Username: " + name);
        writer.println("Phone number: " + phoneNumber);
        writer.println("Email: " + email);
    }
}