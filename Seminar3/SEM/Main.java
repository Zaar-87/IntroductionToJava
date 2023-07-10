package Seminar3.SEM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * 1. Заполнить список десятью случайными числами. Отсортировать список методом sort() и вывести его на экран.
 */

public class Main {
    public static void main(String[] args) {
        //randomNumbers(5, 10);
        //planetsCounter(10);
        crateTable(5);        
    }

    static void randomNumbers(int size, int maxValue) {
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();

        for (int i = 0; i < size; i++)
            nums.add(rand.nextInt(maxValue));

        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();

        nums.sort(Comparator.naturalOrder());

        Iterator<Integer> iter = nums.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    /*
     * 2. Заполнить список названиями планет Солнечной системы в произвольном
     * порядке с повторениями. Вывести название каждой планеты и количество его
     * повторений в списке.
     */
    static void planetsCounter(int n) {
        List<String> listPlanets = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus",
                "Neptune");
        List<String> randPlanets = new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i) + " ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;
        }
        System.out.println();

        for (int i = 0; i < counts.length; i++)
            System.out.printf("%s - %s\n", listPlanets.get(i), counts[i]);
    }

    /*
     * Каталог товаров книжного магазина сохранен в виде двумерного списка
     * List<ArrayList<String>>
     * так, что на 0й позиции каждого внутреннего списка содержится название жанра,
     * а на остальных позициях - названия книг. Напишите метод для заполнения данной
     * структуры/
     */

    static void crateTable(int size){
        List<String> genres = List.of("Fantastic", "Comedy", "Detective", "Horror");
        List<ArrayList<String>> table = new ArrayList<>(genres.size());
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < genres.size(); i++) {
            ArrayList<String> booksOfGenre = new ArrayList<>(size);
            booksOfGenre.add(genres.get(i));
            System.out.printf("Input %d titles of %s genre down here:\n", size, genres.get(i));
            for (int j = 0; j < size; j++) 
                booksOfGenre.add(input.nextLine());

            table.add(booksOfGenre);           
        }

        input.close();

        for (ArrayList<String> books : table) {
            for (String book : books) {
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }
}
