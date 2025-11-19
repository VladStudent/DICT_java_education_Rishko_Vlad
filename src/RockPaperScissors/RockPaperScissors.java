package RockPaperScissors;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RatingManager ratingManager = new RatingManager();
        Game game = new Game(scanner, ratingManager);

        game.start();
    }
}
