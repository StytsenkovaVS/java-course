package ru.sgu;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Subtask1DaysBetween {

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<LocalDate> dates = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String dateString = scanner.nextLine();
            String[] dateParts = dateString.split(" ");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            LocalDate date = LocalDate.of(year, month, day);
            dates.add(date);
        }

        LocalDate minDate = dates.stream().min(LocalDate::compareTo).get();
        LocalDate maxDate = dates.stream().max(LocalDate::compareTo).get();

        long daysBetween = maxDate.toEpochDay() - minDate.toEpochDay();

        System.out.println(daysBetween);
    }
}