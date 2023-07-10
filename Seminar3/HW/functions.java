package Seminar3.HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class functions {

    // finding minimum number function
    public static void findMin() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the size of array: ");
            int size = scanner.nextInt();
            System.out.print("Please, enter the max value of numbers: ");
            int maxValue = scanner.nextInt();

            scanner.close();

            ArrayList<Integer> list = new ArrayList<>(size);
            Random rand = new Random();

            for (int i = 0; i < size; i++)
                list.add(rand.nextInt(maxValue));

            System.out.println("Origin array list: ");
            System.out.println(list);

            System.out.print("The minimum number in array is: ");
            System.out.println(Collections.min(list));
        }
    }

    // finding maximum number function
    public static void findMax() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the size of array: ");
            int size = scanner.nextInt();
            System.out.print("Please, enter the max value of numbers: ");
            int maxValue = scanner.nextInt();

            scanner.close();

            ArrayList<Integer> list = new ArrayList<>(size);
            Random rand = new Random();

            for (int i = 0; i < size; i++)
                list.add(rand.nextInt(maxValue));

            System.out.println("Origin array list: ");
            System.out.println(list);

            scanner.close();

            System.out.print("The maximum number in array is: ");
            System.out.println(Collections.max(list));
        }
    }

    // removing even numbers function
    public static void removeEven() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the size of array: ");
            int size = scanner.nextInt();
            System.out.print("Please, enter the max value of numbers: ");
            int maxValue = scanner.nextInt();

            scanner.close();

            ArrayList<Integer> list = new ArrayList<>(size);
            Random rand = new Random();

            for (int i = 0; i < size; i++)
                list.add(rand.nextInt(maxValue));

            System.out.println("Origin array list: ");
            System.out.println(list);

            list.removeIf(next -> next % 2 == 0);

            System.out.println("The list after removing even numbers: ");
            System.out.println(list);
        }
    }

    // finding average of numbers function
    public static void getAverage() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the size of array: ");
            int size = scanner.nextInt();
            System.out.print("Please, enter the max value of numbers: ");
            int maxValue = scanner.nextInt();

            scanner.close();

            ArrayList<Integer> list = new ArrayList<>(size);
            Random rand = new Random();

            for (int i = 0; i < size; i++)
                list.add(rand.nextInt(maxValue));

            System.out.println("Origin array list: ");
            System.out.println(list);         

            double sum = 0;
            double result = 0.0;
            for (double value : list) {
                sum = sum + value;
            }
            if (list.size() > 0)
                result = sum / list.size();

            System.out.println("Average of numbers in array list: ");
            System.out.printf("%.2f", result);
        }
    }

    // filling the list with random planets from seminar + function with deleting all repeated planets
    static void planetsCounter(int n) {
        List<String> listPlanets = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus",
                "Neptune");
        List<String> randPlanets = new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];
        Random rand = new Random();

        System.out.println("The list of nonunique random planets: ");

        for (int i = 0; i < n; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));

            System.out.print(randPlanets.get(i) + " ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;

        }
        
        System.out.println();

        System.out.println("The list of nonunique random planets with occurrence: ");
        for (int i = 0; i < counts.length; i++)
            System.out.printf("%s - %s\n", listPlanets.get(i), counts[i]);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to delete all repeated planets? Press '1'");
            System.out.println("No, everithing is alright! Press '2'");
            int func = scanner.nextInt();

            scanner.close();
            
            switch(func){
                case 1:               
                    List<String> randPlanetsUnique = new ArrayList<String>();

                    for (int j = 0; j < listPlanets.size(); j++) {
                        for (int k = 0; k < randPlanets.size(); k++) {
                            if (listPlanets.get(j) == randPlanets.get(k)) {
                                randPlanetsUnique.add(randPlanets.get(k));
                                break;
                            }   
                        }
                    }
                    int sizeUniqueList = randPlanetsUnique.size();
                    
                    System.out.println();
                    System.out.println("The list of random planets was: ");
                    System.out.println(randPlanets);

                    System.out.println("The resulting list of unique planets: ");

                    for (int k = 0; k < sizeUniqueList; k++)
                        System.out.printf("%s\n", randPlanetsUnique.get(k));
                case 2:
                break;
                }
            }         
    }
}

