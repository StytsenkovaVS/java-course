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
                    break;
                case "2":
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