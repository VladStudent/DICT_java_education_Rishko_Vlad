package Hangman;

import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secret = words[random.nextInt(words.length)];

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        String guess = scanner.nextLine();

        if (guess.equals(secret)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
