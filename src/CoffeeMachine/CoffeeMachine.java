package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = sc.next();

            if (action.equals("exit")) {
                break;
            } else if (action.equals("remaining")) {
                printState();
            } else if (action.equals("buy")) {
                buyCoffee(sc);
            } else if (action.equals("fill")) {
                fillMachine(sc);
            } else if (action.equals("take")) {
                System.out.println("I gave you " + money);
                money = 0;
            }
        }
    }

    static void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    static void buyCoffee(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = sc.next();

        if (choice.equals("back")) return;

        int w = 0, m = 0, b = 0, cost = 0;

        if (choice.equals("1")) { w = 250; m = 0; b = 16; cost = 4; }
        else if (choice.equals("2")) { w = 350; m = 75; b = 20; cost = 7; }
        else if (choice.equals("3")) { w = 200; m = 100; b = 12; cost = 6; }

        if (water < w) System.out.println("Sorry, not enough water!");
        else if (milk < m) System.out.println("Sorry, not enough milk!");
        else if (beans < b) System.out.println("Sorry, not enough coffee beans!");
        else if (cups == 0) System.out.println("Sorry, not enough cups!");
        else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= w;
            milk -= m;
            beans -= b;
            cups--;
            money += cost;
        }
    }

    static void fillMachine(Scanner sc) {
        System.out.println("Write how many ml of water do you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += sc.nextInt();
    }
}
