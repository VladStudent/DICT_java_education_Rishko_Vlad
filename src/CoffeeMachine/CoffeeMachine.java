package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = sc.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = sc.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = sc.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = sc.nextInt();

        int waterNeeded = cups * 200;
        int milkNeeded = cups * 50;
        int beansNeeded = cups * 15;

        int cupsPossible = Math.min(Math.min(water / 200, milk / 50), beans / 15);

        if (cupsPossible == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsPossible > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (cupsPossible - cups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupsPossible + " cups of coffee");
        }
    }
}
