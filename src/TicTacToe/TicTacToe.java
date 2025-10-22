package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cells:");
        String input = sc.nextLine();

        char[][] field = new char[3][3];
        for (int i = 0; i < 9; i++) {
            field[i / 3][i % 3] = input.charAt(i);
        }

        printField(field);
        analyze(field);
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

    static void analyze(char[][] f) {
        boolean xWins = win(f, 'X');
        boolean oWins = win(f, 'O');
        int countX = count(f, 'X');
        int countO = count(f, 'O');
        int empty = count(f, '_');

        if ((xWins && oWins) || Math.abs(countX - countO) > 1) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (empty > 0) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    static boolean win(char[][] f, char c) {
        for (int i = 0; i < 3; i++)
            if ((f[i][0] == c && f[i][1] == c && f[i][2] == c) ||
                    (f[0][i] == c && f[1][i] == c && f[2][i] == c)) return true;
        return (f[0][0] == c && f[1][1] == c && f[2][2] == c) ||
                (f[0][2] == c && f[1][1] == c && f[2][0] == c);
    }

    static int count(char[][] f, char c) {
        int n = 0;
        for (char[] row : f)
            for (char x : row)
                if (x == c) n++;
        return n;
    }
}
