package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type 'n' for number of monthly payments,");
        System.out.println("type 'a' for annuity monthly payment amount,");
        System.out.println("type 'p' for loan principal:");
        String type = sc.next();

        if (type.equals("n")) {
            System.out.println("Enter the loan principal:");
            double P = sc.nextDouble();
            System.out.println("Enter the monthly payment:");
            double A = sc.nextDouble();
            System.out.println("Enter the loan interest:");
            double interest = sc.nextDouble();

            double i = (interest / 100) / 12;
            double n = Math.log(A / (A - i * P)) / Math.log(1 + i);
            int months = (int) Math.ceil(n);
            int years = months / 12;
            int remainMonths = months % 12;

            System.out.print("It will take ");
            if (years > 0) System.out.print(years + (years == 1 ? " year" : " years"));
            if (years > 0 && remainMonths > 0) System.out.print(" and ");
            if (remainMonths > 0) System.out.print(remainMonths + (remainMonths == 1 ? " month" : " months"));
            System.out.println(" to repay this loan!");
        }

        else if (type.equals("a")) {
            System.out.println("Enter the loan principal:");
            double P = sc.nextDouble();
            System.out.println("Enter the number of periods:");
            int n = sc.nextInt();
            System.out.println("Enter the loan interest:");
            double interest = sc.nextDouble();

            double i = (interest / 100) / 12;
            double A = P * i * Math.pow(1 + i, n) / (Math.pow(1 + i, n) - 1);
            System.out.println("Your monthly payment = " + Math.ceil(A) + "!");
        }

        else if (type.equals("p")) {
            System.out.println("Enter the annuity payment:");
            double A = sc.nextDouble();
            System.out.println("Enter the number of periods:");
            int n = sc.nextInt();
            System.out.println("Enter the loan interest:");
            double interest = sc.nextDouble();

            double i = (interest / 100) / 12;
            double P = A / ((i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1));
            System.out.println("Your loan principal = " + Math.floor(P) + "!");
        }

        else {
            System.out.println("Incorrect option.");
        }

        sc.close();
    }
}
