package ru.sgu;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Subtask1StreamFilter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        List<Integer> numbers = parseInput(input);

        if (numbers != null) {
            filterNumbers(numbers.stream(), x -> x > 10).forEach(System.out::println);
        }

        in.close();

    }

    public static List<Integer> parseInput (String input) {
        try {
            return Stream.of(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static List<Integer> filterNumbers(Stream<Integer> stream, Predicate<Integer> predicate) {
        return stream.filter(predicate).collect(Collectors.toList());
    }
}