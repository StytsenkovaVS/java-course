package ru.sgu.Subtask3;

import java.util.concurrent.ArrayBlockingQueue;

class Consumer implements Runnable {
    private ArrayBlockingQueue<String> queue;
    private String name;
    private int totalCalories = 0;

    public Consumer(ArrayBlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = queue.take();
                String[] parts = item.split(" ");
                String food = parts[0];
                int calories = Integer.parseInt(parts[1]);
                totalCalories += calories;
                System.out.println(name + " съел " + food + ", всего калорий: " + totalCalories );
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}