package ru.sgu;

public class Subtask2MultiThreadSum {

    public static void main(String[] args) {
        int[] array = new int[100000];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println("сумма без потоков: " + sum);

        MultiThreadSum[] threads = new MultiThreadSum[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MultiThreadSum(array, i * (array.length / threads.length),
                                                   (i + 1) * (array.length / threads.length));
            threads[i].start();
        }

        for (MultiThreadSum thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int multyThreadSum = 0;
        for (MultiThreadSum thread : threads) {
            multyThreadSum += thread.getSum();
        }

        System.out.println("сумма многопоточная: " + multyThreadSum);
    }
}

class MultiThreadSum extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int sum;

    public MultiThreadSum(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}