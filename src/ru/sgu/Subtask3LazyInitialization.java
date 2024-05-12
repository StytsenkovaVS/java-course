package ru.sgu;

public class Subtask3LazyInitialization {

    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.executeQuery("SELECT * FROM users");
    }
}

class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}
