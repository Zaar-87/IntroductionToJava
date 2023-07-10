package Seminar2.HW;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class functions {

    static void printFileExtensions() {

        // 1) Напишите метод, который определит тип (расширение) файлов из текущей папки
        // и выведет в консоль результат вида
        // 1 Расширение файла: txt
        // 2 Расширение файла: pdf
        // 3 Расширение файла:
        // 4 Расширение файла: jpg

        File folder = new File("."); 
        File[] files = folder.listFiles(); //temporary java files and hidden files also counted!

        if (files == null) System.out.println("No files found in the directory!");

        if (files != null)
        {
            System.out.println("We have in root directory next files extentions");             
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    String fileName = files[i].getName();
                    int index = fileName.lastIndexOf('.');
                    String extension = "null";
                    if (index > 1)
                        extension = fileName.substring(index + 1);
                    System.out.println(i + " file extension: " + extension);
                }
            }
        }
    }   

    static void bubbleSortLogging(int[] array) {

        // 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат
        // после каждой итерации запишите в лог-файл.

        Logger logger = Logger.getLogger(Main.class.getName());

        try {
            FileHandler fileHandler = new FileHandler("log_bubble_sort.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Fail creating log file!", ex);
            return;
        }

        logger.info("Original array: " + Arrays.toString(array));

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.info("Intermediate operation: " + Arrays.toString(array));
                }
            }
        }
        logger.info("Sorted array: " + Arrays.toString(array));
    }

    public static void jsonParse() {

        // 3) Дана json-строка (можно сохранить в файл и читать из файла)
        // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

        // Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
        // строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

        // Пример вывода:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.

        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String[] string = json.split(",");

        int count1 = 0;
        int count2 = 1;
        int count3 = 2;

        for (int i = 0; i < string.length; i++) {
            if (count1 == 9) {
                break;
            } else {
                String surname = string[count1].replaceAll("\"", "").substring(9).replaceAll(":", "");
                count1 = count1 + 3;
                String grade = string[count2].replaceAll("\"", "").substring(7);
                count2 = count2 + 3;
                String subject = string[count3].replaceAll("\"", "").replaceAll("}", "").substring(8).replaceAll("]",
                        "");
                count3 = count3 + 3;

                StringBuilder result = new StringBuilder();
                result.append("Student " + surname + " got " + grade + " on subject " + subject + ".");
                System.out.println(result.toString());
            }
        }
    }

    public static void calculatorLogging() {

        // 4) К калькулятору из предыдущего ДЗ добавить логирование.

        Logger logger = Logger.getLogger(Main.class.getName());

        try {
            FileHandler fileHandler = new FileHandler("log_calculator.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Fail creating log file!", ex);
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please, enter the first number:\n     ");
            double number1 = scanner.nextDouble();
            System.out.print("Please, enter the first number:\n     ");
            double number2 = scanner.nextDouble();
            System.out.print("Enter the operator (+, -, *, /):\n     ");
            char operator = scanner.next().charAt(0);

            logger.info("Operator entered next numbers: " + number1 + " & " + number2);

            double result = 0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    logger.info("Operator chose +");
                    break;
                case '-':
                    result = number1 - number2;
                    logger.info("Operator chose -");
                    break;
                case '*':
                    result = number1 * number2;
                    logger.info("Operator chose *");
                    break;
                case '/':
                    result = number1 / number2;
                    logger.info("Operator chose /");
                    break;
                default:
                    System.out.println("Error! Try again.");
                    return;
            }
            System.out.print("The result is: ");
            System.out.printf(number1 + " " + operator + " " + number2 + " = " + "%.2f", result);
            logger.info("The result of operation " + number1 + " " + operator + " " + number2 + " was: " + result);
        }
    }

    public static void filterToSQL() {

        // 5) Дана строка sql-запроса "select * from students where ".
        // Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для
        // фильтрации приведены ниже в виде json-строки.
        // Если значение null, то параметр не должен попадать в запрос.
        // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
        // "city":"Moscow", "age":"null"}

        String query = "SELECT * FROM students WHERE ";
        String db = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        db = db.replace("{", "").replace("}", "").replace(":", " = ");

        String[] queryString = db.split(",");
        StringBuilder sb = new StringBuilder();

        sb.append(query);
        for (int i = 0; i < queryString.length; i++) {
            if (!queryString[i].contains("null"))
                sb.append(queryString[i].replaceFirst("\"", "").replaceFirst("\"", ""));
            if (i < queryString.length - 2)
                sb.append(" AND");
        }
        System.out.println(sb);
    }

}
