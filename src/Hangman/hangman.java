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

        // формируем подсказку: первые 2 буквы, остальные дефисы
        StringBuilder hint = new StringBuilder();
        int reveal = Math.min(2, secret.length());
        for (int i = 0; i < reveal; i++) hint.append(secret.charAt(i));
        for (int i = reveal; i < secret.length(); i++) hint.append('-');

        System.out.print("Guess the word " + hint.toString() + ": > ");
        String guess = scanner.nextLine();

        if (guess.equals(secret)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
