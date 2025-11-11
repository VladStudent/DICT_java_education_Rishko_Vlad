package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the loan principal:");
        int principal = sc.nextInt();

        System.out.println("What do you want to calculate?");
        System.out.println("type 'm' – for number of monthly payments,");
        System.out.println("type 'p' – for the monthly payment:");
        String choice = sc.next();

        if (choice.equals("m")) {
            System.out.println("Enter the monthly payment:");
            int payment = sc.nextInt();
            int months = (int) Math.ceil((double) principal / payment);
            if (months == 1) {
                System.out.println("It will take 1 month to repay the loan");
            } else {
                System.out.println("It will take " + months + " months to repay the loan");
            }
        } else if (choice.equals("p")) {
            System.out.println("Enter the number of months:");
            int months = sc.nextInt();
            int payment = (int) Math.ceil((double) principal / months);
            int lastPayment = principal - (months - 1) * payment;
            if (lastPayment != payment) {
                System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment);
            } else {
                System.out.println("Your monthly payment = " + payment);
            }
        } else {
            System.out.println("Incorrect option.");
        }
        sc.close();
    }
}
