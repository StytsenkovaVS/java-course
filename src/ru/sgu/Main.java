package ru.sgu;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 -- Сортировка" +
                    "\n2 -- Обход директории и архивирование." +
                    "\n3 -- Выход.");

            String choice = in.next();

            switch (choice) {
                case "1":
                    File file = new File("input.txt");
                    if(file.exists()){
                        Subtask1 subtask1 = new Subtask1();
                        subtask1.run();
                    } else {
                        System.out.println("Файл input.txt не существует");
                    }
                    break;
                case "2":
                    System.out.println("Введите название директории и имя целевой строки:");
                    String path = in.next();
                    String str = in.next();
                    Subtask2 subtask2 = new Subtask2(path, str);
                    subtask2.run();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Некорректный ввод.");
                    break;
            }
        }
    }
}

