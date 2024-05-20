package ru.sgu;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Subtask3LazyInitialization {

    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/java-task7";
    private String user = "postgres";
    private String password = "123";

    public static void main(String[] args) {
        Subtask3LazyInitialization subtask3LazyInitialization = new Subtask3LazyInitialization();

        try {
            Connection connection = subtask3LazyInitialization.getInstanceOfConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employeeName FROM employeesAge WHERE age > 20");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("employeeName"));
            }

            subtask3LazyInitialization.getInstanceOfCloseConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getInstanceOfConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private void getInstanceOfCloseConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}