package Seminar5.HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

public class Main {

    public static void main(String[] args) throws IOException {
        // переменная описывает вызываемое действие
        String act;

        // загрузка БД
        functions.loadPB();
        // // вывод записей на экран
        // functions.printPhonebook();

        // вывод на экран описания возможных действий с указанием команд
        System.out.println("Please, select an action:");
        System.out.println(" 1.(add) adding contact\n 2.(remove) removing contact\n 3.(tel) find all telephone numbers belonging to the contact\n 4.(nam) find contact belonging to the telephone\n 5.(save)сохранить\n 6.(print) printing all contacts\n 7.exit\n");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while (!act.equals("exit")||!act.equals("7")) 
        {
            if (act.equals("add") || act.equals("1")) {
                System.out.println("Enter a name of the contact:");
                String name = bf.readLine();
                System.out.println("Enter a phone number:");
                String phone = bf.readLine();
                functions.addPB(phone, name);
            }
            if (act.equals("remove")|| act.equals("2")) {
                System.out.println("Enter a name of the contact you want to delete:");
                String name = bf.readLine();
                functions.delPB(name);
            }
            if (act.equals("nam")|| act.equals("3")) {
                System.out.println("Enter searched name of the contact:");
                String surname = bf.readLine();
                String[] numbers = functions.FindNumberPhone(surname);
                for (String number : numbers) {
                    System.out.println(number);
                }
            }
            if (act.equals("tel")|| act.equals("4")) {
                System.out.println("Enter searched phone number of the contact:");
                String number = bf.readLine();
                System.out.println(functions.FindSurname(number));
            }
            if (act.equals("save")|| act.equals("5")) {
                functions.savePB();
            }
            if (act.equals("print")|| act.equals("6")) {
                functions.printPhonebook();
            }            
            System.out.println(" 1.(add) adding contact\n 2.(rem) removing contact\n 3.(tel) find all telephone numbers belonging to the contact\n 4.(nam) find contact belonging to the telephone\n 5.(save)сохранить\n 6.(print) printing all contacts\n 7.exit\n");
            act = bf.readLine();
        }
    }
}