package ru.sgu;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Subtask3 {
    public static void run() {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s");

                    if (parts.length >= 3) {
                        String firstName = parts[1];
                        String lastName = parts[0];
                        String middleName = parts[2];

                        if (lastName.matches("[a-zA-ZА-Яа-я]+")
                                && firstName.matches("[a-zA-ZА-Яа-я]+")
                                && middleName.matches("[a-zA-ZА-Яа-я]+")) {
                            System.out.println(firstName + " " + lastName.charAt(0) + ". "
                                    + middleName.charAt(0) + ".");
                        } else {
                            System.out.println("Ошибка: Фамилия, имя и отчество должны содержать только буквы");
                        }
                    } else {
                        System.out.println("Ошибка: В строке меньше трех последовательностей символов");
                    }
                } else {
                    System.out.println("Пустая строка");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл input.txt не найден");
        }
    }
}