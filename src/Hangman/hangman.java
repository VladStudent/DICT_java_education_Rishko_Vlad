package Hangman;

import java.util.*;

public class hangman {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("HANGMAN");

        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            String command = scanner.nextLine();

            if (command.equals("play")) {
                playRound();
            } else if (command.equals("exit")) {
                break;
            } else {
                // повторно вывести приглашение (по условию)
            }
        }
    }

    private static void playRound() {
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secret = words[random.nextInt(words.length)];

        char[] hidden = new char[secret.length()];
        Arrays.fill(hidden, '-');

        Set<Character> correct = new HashSet<>();
        Set<Character> wrong = new HashSet<>();
        int lives = 8;

        while (lives > 0) {
            System.out.println("\n" + new String(hidden));
            System.out.print("Input a letter: > ");
            String s = scanner.nextLine();

            if (s.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char c = s.charAt(0);
            if (c < 'a' || c > 'z') {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (correct.contains(c) || wrong.contains(c)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            if (secret.indexOf(c) >= 0) {
                for (int i = 0; i < secret.length(); i++) {
                    if (secret.charAt(i) == c) hidden[i] = c;
                }
                correct.add(c);
            } else {
                System.out.println("That letter doesn't appear in the word");
                wrong.add(c);
                lives--;
            }

            if (new String(hidden).equals(secret)) {
                System.out.println("\n" + new String(hidden));
                System.out.println("You guessed the word " + secret + "!");
                System.out.println("You survived!");
                return;
            }
        }

        System.out.println("You lost!");
    }
}
