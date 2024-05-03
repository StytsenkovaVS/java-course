package ru.sgu;

public class Subtask3String {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            sb.append(generateRandomString());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken using StringBuilder: " + (endTime - startTime) + "ms");
    }

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }
}