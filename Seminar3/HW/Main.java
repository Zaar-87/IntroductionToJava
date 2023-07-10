/*
Задание 1
Пусть дан произвольный список целых чисел.

1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение

Задание 2
Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.
 */
package Seminar3.HW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1. Finding minimum number");
            System.out.println("2. Finding maximum number");
            System.out.println("3. Finding average of numbers");
            System.out.println("4. Removing even numbers");
            System.out.println("5. Remove all duplicate elements (from seminar_task_2)");
            int func = in.nextInt();
            
            switch(func){
                case 1:
                    functions.findMin();
                    break;
                case 2:
                    functions.findMax();                  
                    break;
                case 3:
                    functions.getAverage();                 
                    break;
                case 4:
                    functions.removeEven();               
                    break;
                case 5:
                    try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Please, enter the quantity of planets: ");
                    int n = scanner.nextInt();
                    functions.planetsCounter(n);
                    scanner.close();
                    }
                    break;
            }
        }
    }   

} 

