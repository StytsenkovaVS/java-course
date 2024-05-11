package ru.sgu;

public class Subtask3LazyInitialization {
    public static void main(String[] args) {
        ExpensiveObject expensiveObject = ExpensiveObject.getInstance();
        expensiveObject.performExpensiveOperation();
    }
}

class ExpensiveObject {

    private static ExpensiveObject instance;

    private ExpensiveObject() {
    }

    public static ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

    public void performExpensiveOperation() {
        System.out.println("Performing expensive operation");
    }
}
