package Hangman;

import java.util.*;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secret = words[random.nextInt(words.length)];

        char[] hidden = new char[secret.length()];
        Arrays.fill(hidden, '-');

        Set<Character> revealed = new HashSet<>();
        int lives = 8;

        System.out.println("HANGMAN");

        while (lives > 0) {
            System.out.println("\n" + new String(hidden));
            System.out.print("Input a letter: > ");
            String s = scanner.nextLine();
            if (s.length() == 0) continue;
            char c = s.charAt(0);

            if (secret.indexOf(c) >= 0) {
                if (revealed.contains(c)) {
                    System.out.println("No improvements");
                    lives--; // по условию этапа 6: уменьшить попытку если повтор правильной буквы
                } else {
                    // открыть буквы
                    for (int i = 0; i < secret.length(); i++) {
                        if (secret.charAt(i) == c) {
                            hidden[i] = c;
                        }
                    }
                    revealed.add(c);
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }

            if (new String(hidden).equals(secret)) {
                System.out.println("\n" + new String(hidden));
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                return;
            }
        }

        System.out.println("You lost!");
    }
}
