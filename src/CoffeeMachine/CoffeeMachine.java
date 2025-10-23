package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    machine.buy(scanner);
                    break;
                case "fill":
                    machine.fill(scanner);
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    machine.printState();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }
}

class Coffee {

    String name;
    int water;
    int milk;
    int beans;
    int price;

    public Coffee(String name, int water, int milk, int beans, int price) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }
}

class Machine {

    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    private final Coffee espresso = new Coffee("espresso", 250, 0, 16, 4);
    private final Coffee latte = new Coffee("latte", 350, 75, 20, 7);
    private final Coffee cappuccino = new Coffee("cappuccino", 200, 100, 12, 6);


    public void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        switch (choice) {
            case "1":
                tryMakeCoffee(espresso);
                break;
            case "2":
                tryMakeCoffee(latte);
                break;
            case "3":
                tryMakeCoffee(cappuccino);
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }


    private void tryMakeCoffee(Coffee coffee) {
        // Сначала проверки
        if (this.water < coffee.water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < coffee.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.beans < coffee.beans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {

            System.out.println("I have enough resources, making you a coffee!");
            this.water -= coffee.water;
            this.milk -= coffee.milk;
            this.beans -= coffee.beans;
            this.cups -= 1;
            this.money += coffee.price;
        }
    }

 
    public void fill(Scanner scanner) { /*...*/ }
    public void take() { /*...*/ }
    public void printState() { /*...*/ }
}