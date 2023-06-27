/*
1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
2) Вывести все простые числа от 1 до 1000
3) Реализовать простой калькулятор
4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
 */
package Seminar1.HW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1. Calculate the sum of numbers from 1 to n");
            System.out.println("2. Print all prime numbers from 1 to 1000");
            System.out.println("3. A simple calculator");
            System.out.println("4. Math phrase solution");
            System.out.println("Please, select the function:");
            int func = in.nextInt();
            
            switch(func){
                case 1:
                    functions.sum();
                    break;
                case 2:
                    functions.primeNumbers();
                    break;
                case 3:
                    functions.calculator();
                    break;
                case 4:
                    functions.solution("5? + ?9 = 69");
                    break;
            }
        }
    }    
}
