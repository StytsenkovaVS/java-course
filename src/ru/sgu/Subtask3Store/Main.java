package ru.sgu.Subtask3Store;

public class Main {
    public static void main(String[] args) {
        String[] values = {
                "Молоко 200",
                "Банан 100",
                "Манго 150",
                "Авокадо 150",
                "Яйца 1000000",
                "Курица 500",
                "Рис 300",
                "Брокколи 100",
                "Лосось 600",
                "Овсянка 250"
        };
        Store store = new Store();
        for (String value : values) {
            String[] parts = value.split(" ");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            store.addProduct(new Product(name, price));
        }

        int n = 3;
        for (int i = 0; i < n; i++) {
            Customer customer = new Customer("Покупатель" + (i + 1), store);
            customer.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}