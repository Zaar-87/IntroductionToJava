package Seminar5.HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

public class Main{

    public static void main(String[] args) throws IOException {
        HashMap<String, String> phonebook = new HashMap<>();
        System.out.println("Please, select an action:");
        System.out.println(" 1.(add) adding contact\n 2.(print) printing all contacts\n 3. exit\n");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String action;
        action = bf.readLine();
        
        while (!action.equals("3"))
        {
            if (action.equals("add") || action.equals("1")) {
                System.out.println("Enter a name of the contact:");
                String name = bf.readLine();
                System.out.println("Enter a phone number:");
                String phone = bf.readLine();
                functions.add(phonebook, name, phone);
                System.out.println("Contact added successfuly!");
            }
            if (action.equals("print")|| action.equals("2")) 
            {
                if (phonebook.isEmpty()) System.out.println("The phonebook is empty.\n"); 
                else 
                {
                    System.out.println("Contacts in phonebook: ");
                    functions.print(phonebook);
                }
            }            
            System.out.println(" 1.(add) adding contact\n 2.(print) printing all contacts\n 3. exit\n");
            action = bf.readLine();
        }
    }       
}            
