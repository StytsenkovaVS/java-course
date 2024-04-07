package ru.sgu;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Scanner;

public class Subtask2 {
    public static void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите два числа и операцию (ADD, SUB, MULT, DIV, REM, POW).");
        String[] inputParams = in.nextLine().split(" ");
        if (inputParams.length != 3)
            return;

        BigDecimal bigDecNum1 = new BigDecimal(inputParams[0]);
        BigDecimal bigDecNum2 = new BigDecimal(inputParams[1]);
        BigDecimal result = BigDecimal.ZERO;
        String operation = inputParams[2];

        switch (operation) {
            case "ADD":
                result = bigDecNum1.add(bigDecNum2);
                break;
            case "SUB":
                result = bigDecNum1.subtract(bigDecNum2);
                break;
            case "MULT":
                result = bigDecNum1.multiply(bigDecNum2);
                break;
            case "DIV":
                if (bigDecNum2.compareTo(BigDecimal.ZERO) != 0) {
                    result = bigDecNum1.divide(bigDecNum2, BigDecimal.ROUND_HALF_UP);
                } else {
                    System.out.println("Ошибка: нельзя делить на ноль");
                    return;
                }
                break;
            case "REM":
                result = bigDecNum1.remainder(bigDecNum2);
                break;
            case "POW":
                try {
                    BigInteger intNum1 = new BigInteger(inputParams[0]);
                    int intNum2 = Integer.parseInt(inputParams[1]);
                    result = new BigDecimal(intNum1.pow(intNum2));
                } catch (NumberFormatException error) {
                    System.out.println("Ошибка: для выполнения операции POW нужны целые числа.");
                    return;
                }
                break;
            default:
                System.out.println("Ошибка: такой операции не существует");
                return;
        }

        System.out.println(result);
    }
}

