package it.academy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = "/user")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        String info = req.getHeader("User-Agent");
        writer.println("Hi, user!");
        writer.println(info);
    }
}