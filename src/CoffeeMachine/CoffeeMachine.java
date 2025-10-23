package CoffeeMachine;
import java.util.Scanner;


public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Scanner scanner = new Scanner(System.in);


        machine.printState();


        System.out.println("Write action (buy, fill, take):");
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
            default:
                System.out.println("Invalid action");
                break;
        }


        System.out.println();
        machine.printState();
    }
}


class Coffee {
    // (Этот класс не меняется с 4 по 6 этап)
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
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();


        switch (choice) {
            case 1: // Espresso
                this.water -= espresso.water;
                this.beans -= espresso.beans;
                this.money += espresso.price;
                this.cups -= 1;
                break;
            case 2: // Latte
                this.water -= latte.water;
                this.milk -= latte.milk;
                this.beans -= latte.beans;
                this.money += latte.price;
                this.cups -= 1;
                break;
            case 3: // Cappuccino
                this.water -= cappuccino.water;
                this.milk -= cappuccino.milk;
                this.beans -= cappuccino.beans;
                this.money += cappuccino.price;
                this.cups -= 1;
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }


    public void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        this.cups += scanner.nextInt();
    }


    public void take() {
        System.out.println("I gave you " + this.money);
        this.money = 0;
    }


    public void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.money + " of money");
    }
}