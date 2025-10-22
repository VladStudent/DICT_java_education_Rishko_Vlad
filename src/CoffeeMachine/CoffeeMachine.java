package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");

        System.out.println("\nWrite action (buy, fill, take):");
        String action = sc.next();

        if (action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            int choice = sc.nextInt();

            if (choice == 1) { // espresso
                water -= 250; beans -= 16; cups--; money += 4;
            } else if (choice == 2) { // latte
                water -= 350; milk -= 75; beans -= 20; cups--; money += 7;
            } else if (choice == 3) { // cappuccino
                water -= 200; milk -= 100; beans -= 12; cups--; money += 6;
            }
        } else if (action.equals("fill")) {
            System.out.println("Write how many ml of water you want to add:");
            water += sc.nextInt();
            System.out.println("Write how many ml of milk you want to add:");
            milk += sc.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            beans += sc.nextInt();
            System.out.println("Write how many disposable coffee cups you want to add:");
            cups += sc.nextInt();
        } else if (action.equals("take")) {
            System.out.println("I gave you " + money);
            money = 0;
        }

        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
