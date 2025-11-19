package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        stage1(scanner);
        stage2(scanner);
    }

    private static void stage1(Scanner scanner) {
        System.out.println("=== Stage 1 ===");

        System.out.print("Please, enter the number of mycoins you have: ");
        double coins = scanner.nextDouble();

        System.out.print("Please, enter the exchange rate: ");
        double rate = scanner.nextDouble();

        double result = coins * rate;

        System.out.println("The total amount of dollars: " + result);
    }

    private static void stage2(Scanner scanner) {
        System.out.println("\n=== Stage 2 ===");

        System.out.print("Enter how many mycoins you have: ");
        double coins = scanner.nextDouble();

        double ars = coins * 0.82;
        double hnl = coins * 0.17;
        double aud = coins * 1.9622;
        double mad = coins * 0.208;

        System.out.printf("I will get %.2f ARS\n", ars);
        System.out.printf("I will get %.2f HNL\n", hnl);
        System.out.printf("I will get %.2f AUD\n", aud);
        System.out.printf("I will get %.2f MAD\n", mad);
    }
}
