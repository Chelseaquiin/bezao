package numbersInWords;

import java.util.InputMismatchException;
import java.util.Scanner;

import static numbersInWords.Conversion.convertToWords;

// Convert Numbers to Words

public class Main {

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");

        int number = scanner.nextInt();

        System.out.println(convertToWords(number));






    }





}
