package Hangman;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secret = words[random.nextInt(words.length)];

        char[] hidden = new char[secret.length()];
        Arrays.fill(hidden, '-');

        int attempts = 8; // ровно 8 попыток ввода букв

        System.out.println("HANGMAN");

        while (attempts > 0) {
            System.out.println("\n" + new String(hidden));
            System.out.print("Input a letter: > ");
            String s = scanner.nextLine();
            if (s.length() == 0) continue;
            char c = s.charAt(0);

            if (secret.indexOf(c) >= 0) {
                // открыть все вхождения
                for (int i = 0; i < secret.length(); i++) {
                    if (secret.charAt(i) == c) hidden[i] = c;
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
            }

            attempts--; // упрощение: уменьшаем количество попыток после любого ввода

            if (new String(hidden).equals(secret)) {
                System.out.println("\n" + new String(hidden));
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                return;
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage");
    }
}
