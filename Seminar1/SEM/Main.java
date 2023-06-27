package Seminar1.SEM;

import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1. helloUser");
            System.out.println("2. quantityOfSame");
            System.out.println("3. magicIndex");
            System.out.println("4. reversePhrase");
            System.out.println("Please, select the function:");
            int func = in.nextInt();
            
            switch(func){
                case 1:
                    helloUser();
                    break;
                case 2:
                    quantityOfSame();
                    break;
                case 3:
                    magicIndex();
                    break;
                case 4:
                    reversePhrase();
                    break;
            }
        }
    } 

    static void helloUser() {
        Scanner sc = new Scanner(System.in);
        int hour = LocalDateTime.now().getHour();
        System.out.println("Input your name here: ");
        String name = sc.nextLine();

        String dayTime = "";
        if (hour >= 4 && hour < 11)
            dayTime = "morning";
        else if (hour >= 11 && hour < 17)
            dayTime = "day";
        else if (hour >= 17 && hour < 23)
            dayTime = "evening";
        else
            dayTime = "night";

        System.out.printf("Good %s, %s", dayTime, name);

        sc.close();
    }

    static void quantityOfSame() {
        // Задан массив, например, nums = [1,7,3,6,5,6].
        // Написать программу, которая найдет индекс i для этого массива такой,
        // что сумма элементов с индексами < i равна сумме элементов с индексами > i.
        int[] array = new int[] { 1, 1, 0, 1, 1, 1 };

        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                count++;
            else if (count > maxCount) {
                maxCount = count;
                count = 0;
            } else
                count = 0;
        }
        if (count > maxCount)
            maxCount = count;
        System.out.println(maxCount);
    }

    static void magicIndex() {
        // Дан массив двоичных чисел, например [1,1,0,1,1,1],
        // вывести максимальное количество подряд идущих 1.
        int[] array = new int[] { 1, 3, 2, 4, 6 };

        for (int i = 1; i < array.length - 1; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int i1 = 0; i1 < i; i1++)
                leftSum += array[i1];
            for (int i2 = i + 1; i2 < array.length; i2++)
                rightSum += array[i2];

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    static void reversePhrase() {
//Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your phrase: ");
        String phrase = scanner.nextLine();
        String[] words = phrase.split(" ");
        String[] res = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            res[i] = words[words.length - 1 - i];
        }    
        for (String word: res) {
            System.out.print(word + " ");            
        }
        scanner.close();
    }
}
