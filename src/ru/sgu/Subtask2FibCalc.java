package ru.sgu;

import java.util.Scanner;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class Subtask2FibCalc extends RecursiveTask<Integer> {
    private int n;

    public Subtask2FibCalc(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        } else {
            Subtask2FibCalc task1 = new Subtask2FibCalc(n - 1);
            Subtask2FibCalc task2 = new Subtask2FibCalc(n - 2);
            task1.fork();
            return task2.compute() + task1.join();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите N:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Subtask2FibCalc subtask2FibCalc = new Subtask2FibCalc(n);
        int result = forkJoinPool.invoke(subtask2FibCalc);
        System.out.println("N-е число Фибоначчи = " + result);
    }
}