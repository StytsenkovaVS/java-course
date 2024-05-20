package ru.sgu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Subtask2FindArrayEl {
    public static void main(String[] args) {
        Subtask2FindArrayEl instance = new Subtask2FindArrayEl();
        instance.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] stringOfNums = input.trim().split("\\s+");
        int len = stringOfNums.length;
        int[] array = new int[len];
        try {
            for (int i = 0; i < len; i++) {
                array[i] = Integer.parseInt(stringOfNums[i]);
            }
        } catch (NumberFormatException ex) {
            return;
        }
        in.close();
        System.out.println("Второе наибольшее = " + findSecondLargest(array));
        System.out.println("Третье наименьшее = " + findThirdSmallest(array));
    }

    private int findSecondLargest(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("В массиве меньше двух элементов"));
    }

    private int findThirdSmallest(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted()
                .skip(2)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("В массиве меньше трёх элементов"));
    }
}