package Seminar4.HW;

import java.util.ArrayDeque;
import java.util.Deque;

// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.add(3);
        deque1.add(2);
        deque1.add(1);
        deque1.add(-8);

        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.add(5);
        deque2.add(4);
        deque2.add(3);
        deque2.add(1);

        Deque<Integer> multiplicationResult = functions.multiply(deque1, deque2);
        System.out.println("Multiplication Result: " + multiplicationResult);

        Deque<Integer> additionResult = functions.add(deque1, deque2);
        System.out.println("Addition Result: " + additionResult);
    }    
}
