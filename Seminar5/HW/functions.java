package Seminar5.HW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class functions {

    public static void add(HashMap<String, String> phonebook, String name, String phone) {
        phonebook.merge(name, phone, (number1, number2) -> number1 + ", " + number2);
    }

    public static void print(HashMap<String, String> phonebook) 
    {
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(phonebook.entrySet());

        list.sort((object1, object2) -> object2.getValue().length() - object1.getValue().length());
        for (Map.Entry<String, String> entry : list) System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
