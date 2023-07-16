package Seminar6.HW;

import java.util.HashSet;

// Реализуйте класс Cat, включающий в себя от трех полей и от двух методов, определяющих базовый функционал класса
// (за основу можно взять наработки с семинара). Создать два экземпляра класса Cat и вывести информацию о них на экран.

public class Main {
    public static void main(String[] args) {
        
        Cats cat1 = new Cats("Сitrus", "red", "outbred", 2, 0);
        Cats cat2 = new Cats("Felicia", "black", "sphinx", 7, 2);
        Cats cat3 = new Cats("Lux", "2 colored - brown & surcream", "Siamese", 1, 1);
        Cats cat4 = new Cats("Freddy", "blackandwhite", "outbred", 1, 0);
        Cats cat5 = new Cats("Сitrus", "black", "sphinx", 2, 0);

        HashSet<Cats> hashSet = new HashSet<>();
        hashSet.add(cat1);
        hashSet.add(cat2);
        hashSet.add(cat3);
        hashSet.add(cat4);
        hashSet.add(cat5);

        System.out.println("Identity verification: " + cat1.equals(cat2));
        System.out.println("Identity verification: " + cat1.equals(cat5));
        System.out.println("Prize comparison: " + cat1.prizeComparison(cat4));
        System.out.println("Prize comparison: " + cat2.prizeComparison(cat3));

        System.out.println(hashSet);
    }
    
}
