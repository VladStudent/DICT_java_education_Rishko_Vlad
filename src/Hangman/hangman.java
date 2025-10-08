package Hangman;

import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");

        String secret = "python"; // фиксированное слово для этапа 2

        System.out.print("Guess the word: > ");
        String guess = scanner.nextLine();

        if (guess.equals(secret)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
