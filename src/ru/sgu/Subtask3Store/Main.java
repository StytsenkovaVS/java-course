package ru.sgu.Subtask3Store;

import java.util.Random;

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

        new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(1000);
                    store.addProduct(new Product("Продукт" + random.nextInt(100),
                            random.nextInt(500)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        int N = 3;
        for (int i = 1; i <= N; i++) {
            new Customer(store, "Покупатель" + i).start();
        }
    }
}