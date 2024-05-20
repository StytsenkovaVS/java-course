package ru.sgu;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Subtask1StreamFilter {

    public static void main(String[] args) {
        Subtask1StreamFilter instance = new Subtask1StreamFilter();
        instance.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        List<Integer> numbers = parseInput(input);

        if (numbers != null) {
            filterNumbers(numbers.stream(), x -> x > 10).forEach(n -> System.out.print(n + " "));
            System.out.println();
        }

        in.close();
    }

    private List<Integer> parseInput(String input) {
        try {
            return Stream.of(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private List<Integer> filterNumbers(Stream<Integer> stream, java.util.function.Predicate<Integer> predicate) {
        return stream.filter(predicate).collect(Collectors.toList());
    }
}