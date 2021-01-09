package it.academy.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = getServletContext().getInitParameter("databaseURL");
            String user = getServletContext().getInitParameter("databaseUser");
            String password = getServletContext().getInitParameter("databasePassword");
            final Connection connection = DriverManager.getConnection(url, user, password);
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select expenses.num, paydate, " +
                    "name, value from expenses, receivers\n" +
                    "where receiver = receivers.num;");

            while (resultSet.next()) {
                int resultNum = resultSet.getInt(1);
                Date resultData = resultSet.getDate(2);
                String resultReceiver = resultSet.getString(3);
                float resultValue = resultSet.getFloat(4);
                PrintWriter writer = resp.getWriter();
                writer.println("num = " + resultNum + " | data = " + resultData +
                        " | receiver = " + resultReceiver + " | value = " + resultValue);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}