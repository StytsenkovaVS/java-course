package ru.sgu;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Subtask1IncrementCounter {
    public static void main(String[] args) {
        AtomicInteger first = new AtomicInteger(0);
        AtomicInteger second = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> IncrementVariables(first, second));

        Thread thread2 = new Thread(() -> IncrementVariables(first, second));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("значение переменной 1: " + second.get());
        System.out.println("значение переменной 2: " + first.get());
    }

    public static void IncrementVariables(AtomicInteger first, AtomicInteger second){
        if (new Random().nextBoolean()) {
            for (int i = 0; i < 100000; i++) {
                first.incrementAndGet();
            }
            for (int i = 0; i < 100000; i++) {
                second.incrementAndGet();
            }
        } else {
            for (int i = 0; i < 100000; i++) {
                second.incrementAndGet();
            }
            for (int i = 0; i < 100000; i++) {
                first.incrementAndGet();
            }
        }
    }
}
