package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Stage 1 ===");

        System.out.print("Please, enter the number of mycoins you have: ");
        double coins = scanner.nextDouble();

        System.out.print("Please, enter the exchange rate: ");
        double rate = scanner.nextDouble();

        double result = coins * rate;

        System.out.println("The total amount of dollars: " + result);
    }
}
