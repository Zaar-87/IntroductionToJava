package Seminar4.HW;

import java.util.Deque;
import java.util.LinkedList;

//Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
//1) Умножьте два числа и верните произведение в виде связанного списка.
//2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.

public class functions {

    // multiplication function
    public static Deque<Integer> multiply(Deque<Integer> deque1, Deque<Integer> deque2) {

        int number1 = dequeToNumber(deque1);
        int number2 = dequeToNumber(deque2);

        int production = number1 * number2;

        return numberToDeque(production);
    }

    // addition function
    public static Deque<Integer> add(Deque<Integer> deque1, Deque<Integer> deque2) {

        int number1 = dequeToNumber(deque1);       
        int number2 = dequeToNumber(deque2);

        int summary = number1 + number2;

        return numberToDeque(summary);
    }

    // transformation deq -> num
    public static int dequeToNumber(Deque<Integer> deque) {
        int num = 0;
        int multiplier = 1;

        while (!deque.isEmpty()) 
        {
            int digit = deque.removeFirst();
            num += digit * multiplier;
            multiplier *= 10;
        }
        return num;
    }

    // transformation num -> deq
    public static Deque<Integer> numberToDeque(int num) {
        Deque<Integer> deque = new LinkedList<>();
        int count = String.valueOf(num).length();

        for (int i = 0; i < count; i++) 
        {
            int digit = num % 10;
            deque.addFirst(digit);
            num /= 10;
        }
        return deque;
    }
}