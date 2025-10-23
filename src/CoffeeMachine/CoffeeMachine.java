package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP = 50;
        final int BEANS_PER_CUP = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        int stockWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int stockMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int stockBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int desiredCups = scanner.nextInt();

        int maxCupsByWater = (stockWater >= WATER_PER_CUP) ? stockWater / WATER_PER_CUP : 0;
        int maxCupsByMilk = (stockMilk >= MILK_PER_CUP) ? stockMilk / MILK_PER_CUP : 0;
        int maxCupsByBeans = (stockBeans >= BEANS_PER_CUP) ? stockBeans / BEANS_PER_CUP : 0;

        int actualMaxCups = Math.min(maxCupsByWater, Math.min(maxCupsByMilk, maxCupsByBeans));

        if (actualMaxCups == desiredCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (actualMaxCups > desiredCups) {
            int extraCups = actualMaxCups - desiredCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + actualMaxCups + " cups of coffee");
        }
    }
}