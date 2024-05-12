package ru.sgu;

import java.sql.*;

public class DataBase {

    private static final String url = "jdbc:postgresql://localhost:5432/java-task7";
    private static final String user = "postgres";
    private static final String password = "123";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Сотрудники, чей возраст больше 20:");
            String query1 = "SELECT employeeName FROM employeesAge WHERE age > 20";
            executeQuery(connection, query1);

            System.out.println("\nСредняя зарплата по каждому отделу:");
            String query2 = "SELECT departmentName, ROUND(AVG(salary), 0) AS averageSalary FROM departmentSalary GROUP BY departmentName";
            executeQuery(connection, query2);

            System.out.println("\nСотрудник, его департамент и место работы:");
            String query3 = "SELECT e.employeeName, d.departmentName, d.location " +
                    "FROM departmentEmployee e " +
                    "JOIN departmentLocation d ON e.departmentId = d.departmentId";
            executeQuery(connection, query3);

            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер JDBC для PostgreSQL не найден.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных.");
            e.printStackTrace();
        }
    }

    private static void executeQuery(Connection connection, String query) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }
    }
}
