package RockPaperScissors;

import java.util.*;

public class Game {

    private final Scanner scanner;
    private final RatingManager ratingManager;

    private String userName;
    private int userScore = 0;

    private final List<String> options = Arrays.asList("rock", "paper", "scissors");

    public Game(Scanner scanner, RatingManager ratingManager) {
        this.scanner = scanner;
        this.ratingManager = ratingManager;
    }

    public void start() {
        System.out.print("Enter your name: ");
        userName = scanner.nextLine();

        System.out.println("Hello, " + userName);

        userScore = ratingManager.getUserRating(userName);

        System.out.println("Okay, let's start");

        gameLoop();
    }

    private void gameLoop() {
        Random random = new Random();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }

            if (input.equals("!rating")) {
                System.out.println("Your rating: " + userScore);
                continue;
            }

            if (!options.contains(input)) {
                System.out.println("Invalid input");
                continue;
            }

            String computerChoice = options.get(new Random().nextInt(options.size()));

            Result result = getResult(input, computerChoice);
            printResult(result, computerChoice);
        }
    }

    private Result getResult(String user, String comp) {
        if (user.equals(comp)) return Result.DRAW;

        if (
                (user.equals("rock") && comp.equals("scissors")) ||
                        (user.equals("paper") && comp.equals("rock")) ||
                        (user.equals("scissors") && comp.equals("paper"))
        ) {
            userScore += 100;
            return Result.WIN;
        }

        return Result.LOSE;
    }

    private void printResult(Result result, String comp) {
        switch (result) {
            case WIN:
                System.out.println("Well done. The computer chose " + comp + " and failed");
                break;
            case DRAW:
                userScore += 50;
                System.out.println("There is a draw (" + comp + ")");
                break;
            case LOSE:
                System.out.println("Sorry, but the computer chose " + comp);
                break;
        }
    }
}
