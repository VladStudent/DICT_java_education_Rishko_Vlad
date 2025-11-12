package RockPaperScissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        int rating = 0;
        try {
            File file = new File("rating.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String user = fileScanner.next();
                int score = fileScanner.nextInt();
                if (user.equals(name)) {
                    rating = score;
                    break;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("rating.txt not found, starting from 0 points.");
        }

        String[] options = {"rock", "paper", "scissors"};
        System.out.println("Okay, let's start");

        while (true) {
            String userChoice = scanner.nextLine();

            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
                continue;
            }

            boolean valid = false;
            for (String opt : options) {
                if (opt.equals(userChoice)) {
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                System.out.println("Invalid input");
                continue;
            }

            String computerChoice = options[random.nextInt(options.length)];

            if (userChoice.equals(computerChoice)) {
                System.out.println("There is a draw (" + computerChoice + ")");
                rating += 50;
            } else if (
                    (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                            (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                rating += 100;
            } else {
                System.out.println("Sorry, but the computer chose " + computerChoice);
            }
        }
    }
}
