package ru.sgu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 -- Вывод Hello world." +
                    "\n2 -- Вывод Hello world." +
                    "\n3 -- Вывод Hello world." +
                    "\n4 -- Выход.");

            String choice = in.next();

            switch (choice) {
                case "1":
                    Subtask1 subtask1 = new Subtask1();
                    subtask1.run();
                    break;
                case "2":
                    Subtask2 subtask2 = new Subtask2();
                    subtask2.run();
                    break;
                case "3":
                    Subtask3 subtask3 = new Subtask3();
                    subtask3.run();
                    break;
                case "4":
                    in.close();
                    return;
                default:
                    System.out.println("Некорректный ввод.");
            }
        }
    }
}