package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cells:");
        String input = sc.nextLine();
        char[][] field = new char[3][3];
        for (int i = 0; i < 9; i++) field[i / 3][i % 3] = input.charAt(i);

        printField(field);

        while (true) {
            System.out.println("Enter the coordinates:");
            String x = sc.next();
            String y = sc.next();

            if (!x.matches("\\d+") || !y.matches("\\d+")) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int a = Integer.parseInt(x);
            int b = Integer.parseInt(y);

            if (a < 1 || a > 3 || b < 1 || b > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int row = a - 1;
            int col = b - 1;

            if (field[row][col] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            field[row][col] = 'X';
            printField(field);
            break;
        }
    }

    static void printField(char[][] f) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
