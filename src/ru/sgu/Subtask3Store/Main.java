package ru.sgu.Subtask3Store;

import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        int N = 3;
        int customerDelay = 3;
        int productDelay = 1;

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(N+1);

        executor.scheduleAtFixedRate(() -> {
            Random random = new Random();
            store.addProduct(new Product("Продукт" + random.nextInt(100), random.nextInt(500)));
        }, 0, productDelay, TimeUnit.SECONDS);

        for (int i = 1; i <= N; i++) {
            Customer customer = new Customer(store, "Покупатель" + i);
            executor.scheduleAtFixedRate(customer, customerDelay, customerDelay, TimeUnit.SECONDS);
        }
    }
}