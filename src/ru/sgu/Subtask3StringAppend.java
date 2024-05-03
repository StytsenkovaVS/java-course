package ru.sgu;

import java.util.Random;

public class Subtask3StringAppend {

    private int iterations = 100_000;
    private int strLen = 10;

    private void stringBuilderTesting() {
        StringBuilder stringBuilder = new StringBuilder(iterations * strLen);
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(generateRandomString(strLen));
        }
    }

    private void stringBufferTesting() {
        StringBuffer stringBuffer = new StringBuffer(iterations * strLen);
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(generateRandomString(strLen));
        }
    }

    private void stringTesting() {
        String string = "";
        for (int i = 0; i < iterations; i++) {
            string += generateRandomString(strLen);
        }
    }

    private String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((char) (random.nextInt(26) + 'a'));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Subtask3StringAppend subtask3 = new Subtask3StringAppend();
        long startTime = System.currentTimeMillis();
        subtask3.stringBuilderTesting();
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        subtask3.stringBufferTesting();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        subtask3.stringTesting();
        endTime = System.currentTimeMillis();
        System.out.println("String: " + (endTime - startTime) + " мс");

    }

}