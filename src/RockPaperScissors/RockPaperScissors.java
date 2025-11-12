package RockPaperScissors;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        String computerChoice = "";
        switch (userChoice) {
            case "rock":
                computerChoice = "paper";
                break;
            case "paper":
                computerChoice = "scissors";
                break;
            case "scissors":
                computerChoice = "rock";
                break;
        }

        System.out.println("Sorry, but the computer chose " + computerChoice);
    }
}
