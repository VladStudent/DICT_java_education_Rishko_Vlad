import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Java");
    }
}




//
//package CoffeeMachine;
//
//import java.util.Scanner;
//
//
//public class CoffeeMachine {
//
//    public static void main(String[] args) {
//
//        Machine machine = new Machine();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            machine.printPrompt();
//            String input = scanner.nextLine();
//            if (!machine.processInput(input)) {
//                break;
//            }
//        }
//    }
//}
//
//
//class Coffee {
//    String name;
//    int water;
//    int milk;
//    int beans;
//    int price;
//
//    public Coffee(String name, int water, int milk, int beans, int price) {
//        this.name = name;
//        this.water = water;
//        this.milk = milk;
//        this.beans = beans;
//        this.price = price;
//    }
//}
//
//
//class Machine {
//
//    private int water = 400;
//    private int milk = 540;
//    private int beans = 120;
//    private int cups = 9;
//    private int money = 550;
//
//
//    private enum State {
//        CHOOSING_ACTION,
//        CHOOSING_COFFEE,
//        FILLING_WATER,
//        FILLING_MILK,
//        FILLING_BEANS,
//        FILLING_CUPS
//    }
//
//    private State currentState;
//
//
//    private final Coffee espresso = new Coffee("espresso", 250, 0, 16, 4);
//    private final Coffee latte = new Coffee("latte", 350, 75, 20, 7);
//    private final Coffee cappuccino = new Coffee("cappuccino", 200, 100, 12, 6);
//
//
//    public Machine() {
//        this.currentState = State.CHOOSING_ACTION;
//    }
//
//
//    public void printPrompt() {
//        switch (this.currentState) {
//            case CHOOSING_ACTION:
//                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
//                break;
//            case CHOOSING_COFFEE:
//                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
//                break;
//            case FILLING_WATER:
//                System.out.println("Write how many ml of water you want to add:");
//                break;
//            case FILLING_MILK:
//                System.out.println("Write how many ml of milk you want to add:");
//                break;
//            case FILLING_BEANS:
//                System.out.println("Write how many grams of coffee beans you want to add:");
//                break;
//            case FILLING_CUPS:
//                System.out.println("Write how many disposable cups of coffee you want to add:");
//                break;
//        }
//    }
//
//
//    public boolean processInput(String input) {
//        switch (this.currentState) {
//            case CHOOSING_ACTION:
//                return handleActionChoice(input);
//
//            case CHOOSING_COFFEE:
//                handleCoffeeChoice(input);
//                break;
//
//            case FILLING_WATER:
//                this.water += Integer.parseInt(input);
//                this.currentState = State.FILLING_MILK;
//                break;
//            case FILLING_MILK:
//                this.milk += Integer.parseInt(input);
//                this.currentState = State.FILLING_BEANS;
//                break;
//            case FILLING_BEANS:
//                this.beans += Integer.parseInt(input);
//                this.currentState = State.FILLING_CUPS;
//                break;
//            case FILLING_CUPS:
//                this.cups += Integer.parseInt(input);
//                this.currentState = State.CHOOSING_ACTION;
//                break;
//        }
//        return true;
//    }
//
//
//    private boolean handleActionChoice(String action) {
//        switch (action) {
//            case "buy":
//                this.currentState = State.CHOOSING_COFFEE;
//                break;
//            case "fill":
//                this.currentState = State.FILLING_WATER;
//                break;
//            case "take":
//                handleTake();
//                break;
//            case "remaining":
//                printState();
//                break;
//            case "exit":
//                return false;
//            default:
//                System.out.println("Invalid action");
//                break;
//        }
//        return true;
//    }
//
//
//    private void handleCoffeeChoice(String choice) {
//        switch (choice) {
//            case "1":
//                tryMakeCoffee(espresso);
//                break;
//            case "2":
//                tryMakeCoffee(latte);
//                break;
//            case "3":
//                tryMakeCoffee(cappuccino);
//                break;
//            case "back":
//
//                break;
//            default:
//                System.out.println("Invalid choice");
//                break;
//        }
//
//        this.currentState = State.CHOOSING_ACTION;
//    }
//
//
//    private void handleTake() {
//        System.out.println("I gave you " + this.money);
//        this.money = 0;
//    }
//
//
//    private void printState() {
//        System.out.println("\nThe coffee machine has:");
//        System.out.println(this.water + " of water");
//        System.out.println(this.milk + " of milk");
//        System.out.println(this.beans + " of coffee beans");
//        System.out.println(this.cups + " of disposable cups");
//        System.out.println(this.money + " of money");
//    }
//
//
//    private void tryMakeCoffee(Coffee coffee) {
//
//        if (this.water < coffee.water) {
//            System.out.println("Sorry, not enough water!");
//        } else if (this.milk < coffee.milk) {
//            System.out.println("Sorry, not enough milk!");
//        } else if (this.beans < coffee.beans) {
//            System.out.println("Sorry, not enough coffee beans!");
//        } else if (this.cups < 1) {
//            System.out.println("Sorry, not enough disposable cups!");
//        } else {
//
//            System.out.println("I have enough resources, making you a coffee!");
//            this.water -= coffee.water;
//            this.milk -= coffee.milk;
//            this.beans -= coffee.beans;
//            this.cups -= 1;
//            this.money += coffee.price;
//        }
//    }
//}
