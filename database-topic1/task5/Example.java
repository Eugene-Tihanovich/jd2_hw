package it.academy;

import java.sql.*;

public class Example {

    public static void main(String[] args) {

        //в качестве исходных параметров main были "6" "2020-12-29" "3" "3000"

        String num = args[0];
        String paydate = args[1].replaceAll("-", "");
        String receiver = args[2];
        String value = args[3];

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/listexpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root"
            );
            final PreparedStatement preparedStatement = connection.prepareStatement("insert into expenses " +
                    "(num, paydate, receiver, value) values (?, ?, ?, ?)");
            preparedStatement.setInt(1, Integer.parseInt(num));
            preparedStatement.setDate(2, Date.valueOf(paydate));
            preparedStatement.setString(3, receiver);
            preparedStatement.setFloat(4, Float.parseFloat(value));

            final ResultSet resultSet = preparedStatement.executeQuery("select expenses.num, paydate, " +
                    "name, value from expenses, receivers\n" +
                    "where receiver = receivers.num;");

            while (resultSet.next()) {
                int resultNum = resultSet.getInt(1);
                Date resultData = resultSet.getDate(2);
                String resultReceiver = resultSet.getString(3);
                float resultValue = resultSet.getFloat(4);
                System.out.println("num = " + resultNum + " | data = " + resultData +
                        " | receiver = " + resultReceiver + " | value = " + resultValue);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}