package ru.sgu.Subtask3Store;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();

        int N = 4;
        int customerDelayM = 3;
        int productDelayL = 1;

        ScheduledThreadPoolExecutor productExecutor = new ScheduledThreadPoolExecutor(1);
        productExecutor.scheduleAtFixedRate(() -> {
            Random random = new Random();
            store.addProduct(new Product("Продукт" + random.nextInt(100), random.nextInt(500)));
        }, 0, productDelayL, TimeUnit.SECONDS);

        ScheduledExecutorService customerExecutor = Executors.newScheduledThreadPool(N);

        for (int i = 1; i <= N; i++) {
            Customer customer = new Customer(store, "Покупатель" + i);
            customerExecutor.scheduleAtFixedRate(customer, customerDelayM, customerDelayM, TimeUnit.SECONDS);
        }

        Thread.sleep(50 * 1000);

        customerExecutor.shutdown();
        productExecutor.shutdown();
    }
}