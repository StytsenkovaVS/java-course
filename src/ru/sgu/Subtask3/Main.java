package ru.sgu.Subtask3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число потребителей:");
        Scanner in = new Scanner(System.in);
        int numConsumers = in.nextInt();
        in.close();

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        for (int i = 1; i <= numConsumers; i++) {
            Thread consumerThread = new Thread(new Consumer(queue, "Потребитель " + i));
            consumerThread.start();
        }

        Thread producerThread = new Thread(new Producer(queue));
        producerThread.start();
    }
}