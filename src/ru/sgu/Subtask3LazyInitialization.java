package ru.sgu;

import java.sql.*;

public class Subtask3LazyInitialization {

    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/java-task7";
    private static String user = "postgres";
    private static String password = "123";

    public static Connection getInstanceOfConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void getInstanceOfCloseConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = Subtask3LazyInitialization.getInstanceOfConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employeeName FROM employeesAge WHERE age > 20");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("employeeName"));
            }

            Subtask3LazyInitialization.getInstanceOfCloseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}