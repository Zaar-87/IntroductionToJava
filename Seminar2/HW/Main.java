package Seminar2.HW;

// import java.io.IOException;
// import java.util.Arrays;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import java.util.logging.SimpleFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1. Printing all file extensions in root");
            System.out.println("2. 'Bubble Sort' with logging");
            System.out.println("3. Parsing from json format");
            System.out.println("4. 'Calculator' with logging");
            System.out.println("5. Simple SQL filtering");
            System.out.println("Please, select the function:");
            int func = in.nextInt();
            
            switch(func){
                case 1:               
                    functions.printFileExtensions();
                    break;
                case 2:
                    int[] array = {12, 36, 15, 111, 6};
                    functions.bubbleSortLogging(array);
                    break;
                case 3:
                    functions.jsonParse();
                    break;
                case 4:
                    functions.calculatorLogging();
                    break;
                case 5:
                    functions.filterToSQL();
                    break;    
            }
        }
    }    
}
