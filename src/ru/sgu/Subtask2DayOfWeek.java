package ru.sgu;

import java.util.Scanner;

public class Subtask2DayOfWeek {

    enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();
        String[] parts = input.split(" ");
        String inputDay = parts[0].toUpperCase();
        int days = Integer.parseInt(parts[1]) % 7;

        DayOfWeek currentDay = DayOfWeek.valueOf(inputDay);
        DayOfWeek nextDay = getNextDay(currentDay, days);

        System.out.println(nextDay);
    }

    public static DayOfWeek getNextDay(DayOfWeek currentDay, int days) {
        int currentIndex = currentDay.ordinal();
        int newIndex = (currentIndex + days) % 7;
        return DayOfWeek.values()[newIndex];
    }
}