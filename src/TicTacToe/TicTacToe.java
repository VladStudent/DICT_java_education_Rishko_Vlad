package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] field = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        printField(field);

        boolean xTurn = true;

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

            if (field[row][col] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            field[row][col] = xTurn ? 'X' : 'O';
            printField(field);

            String result = checkGame(field);
            if (!result.equals("Game not finished")) {
                System.out.println(result);
                break;
            }

            xTurn = !xTurn;
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

    static String checkGame(char[][] f) {
        if (win(f, 'X')) return "X wins";
        if (win(f, 'O')) return "O wins";
        for (char[] row : f)
            for (char c : row)
                if (c == ' ') return "Game not finished";
        return "Draw";
    }

    static boolean win(char[][] f, char c) {
        for (int i = 0; i < 3; i++)
            if ((f[i][0] == c && f[i][1] == c && f[i][2] == c) ||
                    (f[0][i] == c && f[1][i] == c && f[2][i] == c))
                return true;
        return (f[0][0] == c && f[1][1] == c && f[2][2] == c) ||
                (f[0][2] == c && f[1][1] == c && f[2][0] == c);
    }
}
