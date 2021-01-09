package it.academy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "UniqueCounterServlet", urlPatterns = "/test")
public class UniqueCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Cookie[] myCookies = req.getCookies();
        String cookieName = "cookieName";
        String cookieValue = "cookieValue";

        Path path = Path.of("d:\\jd2_hw\\servlets-topic4\\task13\\uniqueviews.txt");

        String num = Files.readString(path, StandardCharsets.UTF_8);

        int count = Integer.parseInt(num);

        for (Cookie resultCookie : myCookies) {
            if (cookieName.equals(resultCookie.getName()) && cookieValue.equals(resultCookie.getValue())) {
                break;
            } else {
                Cookie cookie = new Cookie("cookieName", "cookieValue");
                cookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(cookie);
                count++;
                Files.writeString(path, String.valueOf(count));
            }
        }

        final PrintWriter writer = resp.getWriter();
        writer.println("Number of views = " + count);

    }
}