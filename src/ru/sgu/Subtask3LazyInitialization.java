package ru.sgu;

public class Subtask3LazyInitialization {

    public static void main(String[] args) {
        // Используем наш класс с отложенной инициализацией
        DatabaseConnection connection = DatabaseConnection.getInstance();
        // Теперь можем использовать соединение с базой данных
        connection.executeQuery("SELECT * FROM users");
    }
}

class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Приватный конструктор, чтобы избежать создания объектов извне
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        // Ваш код для выполнения запроса к базе данных
        System.out.println("Executing query: " + query);
    }
}
