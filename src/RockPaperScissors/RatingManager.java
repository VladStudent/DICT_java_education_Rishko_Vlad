package RockPaperScissors;

import java.io.File;
import java.util.Scanner;

public class RatingManager {

    public int getUserRating(String userName) {
        int rating = 0;

        try {
            File file = new File("rating.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                int score = fileScanner.nextInt();

                if (name.equals(userName)) {
                    rating = score;
                    break;
                }
            }

            fileScanner.close();

        } catch (Exception e) {
            // Якщо файлу немає — рейтинг починається з нуля
        }

        return rating;
    }
}
