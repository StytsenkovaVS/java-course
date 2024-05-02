package ru.sgu;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtask1IncrementCounter {

    public static void main(String[] args) {
        AtomicInteger sharedVariable = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                sharedVariable.incrementAndGet();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                sharedVariable.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Конечное значение переменной: " + sharedVariable.get());
    }
}