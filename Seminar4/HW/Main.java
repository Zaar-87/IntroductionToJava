package Seminar4.HW;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
//1) Умножьте два числа и верните произведение в виде связанного списка.
//2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        deque1.add(1);
        deque1.addFirst(5);
                
        deque2.add(3);
        deque2.addFirst(-4);

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("1. Multiplication");
                System.out.println("2. Addition");
                int func = scanner.nextInt();

                scanner.close();

                        System.out.println("First deque:");  
                        System.out.println(deque1);
                        System.out.println("Secondary deque:");        
                        System.out.println(deque2);

                switch (func) 
                {
                    case 1:
                        Deque<Integer> multiplicationResult = functions.multiply(deque1, deque2);
                        System.out.println("Product of deques: " + multiplicationResult);
                        break;
                    case 2:
                        Deque<Integer> summaryResult = functions.add(deque1, deque2);
                        System.out.println("Sum of deques: " + summaryResult);
                        break;
                    default:
                        System.out.println("Error! Please try again!");
                }
            }
        }
}
