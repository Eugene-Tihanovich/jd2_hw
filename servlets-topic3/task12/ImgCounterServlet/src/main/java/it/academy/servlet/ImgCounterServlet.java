package it.academy.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "ImgCounterServlet", urlPatterns = "/example")
public class ImgCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);

        Path path = Path.of("d:\\jd2_hw\\servlets-topic3\\task12\\views.txt");

        String num = Files.readString(path, StandardCharsets.UTF_8);

        int count = Integer.parseInt(num);
        count++;

        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics.setColor(Color.red);
        graphics.drawString(String.valueOf(count), 100, 100);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);

        Files.writeString(path, String.valueOf(count));
    }
}