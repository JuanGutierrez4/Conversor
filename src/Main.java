

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        ConsultCurrency consult = new ConsultCurrency();

        while (true) {
            System.out.println("Welcome to currency converter");

            int maxCurrencyOptions = consult.getIsoListSize();

            int numberOne = getValidNumber(reading, "What is your first currency? ", 0, maxCurrencyOptions, consult);
            if (numberOne == 0) {
                break;
            }

            int numberTwo = getValidNumber(reading, "What's your second currency? ", 1, maxCurrencyOptions, consult);

            System.out.println("***************************************************");
            System.out.println("Enter the value you want to convert: ");
            int value = getValidInteger(reading);

            CurrencyOmdb currencyOmdb = consult.consultCurrency(numberOne, numberTwo, value);
        }
    }

    private static int getValidNumber(Scanner reading, String prompt, int min, int max, ConsultCurrency consult) {
        int number;
        while (true) {
            System.out.println("***************************************************");
            System.out.println(prompt);
            if (min == 0) {
                System.out.println("0) Leave");
            }
            for (int i = 1; i <= consult.getIsoListSize(); i++) {
                System.out.println(i + ") " + consult.getIso().get(i - 1));
            }
            System.out.print("Enter your number: ");
            try {
                number = Integer.parseInt(reading.nextLine());
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.out.println("Please enter a valid number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return number;
    }

    private static int getValidInteger(Scanner reading) {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(reading.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return number;
    }
}
