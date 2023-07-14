package Seminar5.SEM;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // ex1();
        // ex2();
        // ex3_1();
        ex3_2();        
    }

    // Task 1. Создать структуру для хранения номеров паспортов и фамилий сотрудников.
    static void ex1() {
        Map<String, String> workers = new HashMap<>();
        workers.put("100", "Ivanov");
        workers.put("101", "Petrov");
        workers.put("102", "Sidorov");
        workers.put("103", "Ivanov");

        for (Map.Entry<String, String> worker : workers.entrySet()) {
            if (worker.getValue().equals("Ivanov"))
                System.out.printf("Passport number: %s, Worker surname: %s\n", worker.getKey(), worker.getValue());
        }
    }
    // Task 2. Перевести из римских цифр в арабские
    static void ex2() {
        Map<Character, Integer> rimNums = new HashMap<>();
        rimNums.put('I', 1);
        rimNums.put('V', 5);
        rimNums.put('X', 10);
        rimNums.put('L', 50);
        rimNums.put('C', 100);
        rimNums.put('D', 500);
        rimNums.put('M', 1000);

        Scanner input = new Scanner(System.in);

        System.out.println("Input a number ina roman case: ");
        char[] romeNumber = input.nextLine().toUpperCase().toCharArray();

        int res = 0;

        for (int i = 0; i < romeNumber.length; i++) 
        {
            if (i != romeNumber.length - 1 && rimNums.get(romeNumber[i]) < rimNums.get(romeNumber[i + 1])) 
            {
                res += rimNums.get(romeNumber[i + 1]) - rimNums.get(romeNumber[i]);
                i++;
            }
            else res += rimNums.get(romeNumber[i]);
        }
        System.out.println(res);
        input.close();
    }
    // Task 3. Написать метод, который сортирует строки по длине с помощью TreeMap.
    static void ex3_1() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input a string: ");
        String[] words = input.nextLine().split(" ");

        Map<Integer, String> sortedWords = new TreeMap<>();

        for (String word : words) 
            sortedWords.put(word.length(), word);
        System.out.println(sortedWords);
        input.close();
    }

    static void ex3_2() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input a string: ");
        String[] words = input.nextLine().split(" ");

        Map<Integer, LinkedList<String>> sortedWords = new TreeMap<>();
        
        for (String word : words) {
            if(sortedWords.containsKey(word.length()))
            {
                sortedWords.get(word.length()).add(word);
            }
            else
            {
                sortedWords.put(word.length(), new LinkedList<>());
                sortedWords.get(word.length()).add(word);
            }
        }
        System.out.println(sortedWords);
        input.close();
    }
}
