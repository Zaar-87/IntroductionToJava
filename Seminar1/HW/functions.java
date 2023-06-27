package Seminar1.HW;

import java.util.Scanner;

public class functions {

    // sum function
    public static void sum() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the number 'n': ");
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("Sum of numbers from 1 to " + n + " is " + sum);
        }
    }

    // prime function
    public static void primeNumbers() {

        System.out.println("All prime numbers from 1 to 1000: ");
        for (int i = 1; i < 1001; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.print(i + ", ");
            }
        }
    }

    // calculator function
    public static void calculator() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the first number:\n     ");
            double number1 = scanner.nextDouble();
            System.out.print("Please, enter the first number:\n     ");
            double number2 = scanner.nextDouble();
            System.out.print("Enter the operator (+, -, *, /):\n     ");
            char operator = scanner.next().charAt(0);

            double result = 0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
                default:
                    System.out.println("Error! Try again.");
                    return;
            }
            System.out.print("The result is: ");
            System.out.printf(number1 + " " + operator + " " + number2 + " = " + "%.2f", result);
        }
    }

    public static boolean valid(int first, int second, int result) {
        return first + second == result;
    }

    public static void solutionExample(String expression) {
        String[] numbers = expression.split("=");
        int resultExpression = Integer.parseInt(numbers[1].trim());
        String[] leftExpression = numbers[0].trim().replaceFirst(" ", "").replace("+", "").split(" ");
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            int first = Integer.parseInt(leftExpression[0].replace("?", String.valueOf(i)));
            for (int j = 0; j < 10; j++) {
                int second = Integer.parseInt(leftExpression[1].replace("?", String.valueOf(j)));
                if (valid(first, second, resultExpression)) {
                    System.out.println(first + " + " + second + " = " + resultExpression);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag)
            System.out.println("Решения нет");
    }
}