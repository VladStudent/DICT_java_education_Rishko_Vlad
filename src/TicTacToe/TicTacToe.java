package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        game.printBoard();

        while (true) {
            System.out.println("Enter the coordinates (row and column, for example: 1 3):");
            String input = scanner.nextLine();

            if (!game.processMove(input)) {
                continue;
            }

            game.printBoard();

            String result = game.checkGameState();
            if (!result.equals("Game not finished")) {
                System.out.println(result);
                break;
            }
        }
    }
}


class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.currentPlayer = playerX;
    }

    public void printBoard() {
        board.print();
    }

    public boolean processMove(String input) {
        String[] parts = input.trim().split(" ");
        if (parts.length != 2) {
            System.out.println("You should enter two numbers!");
            return false;
        }

        try {
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }

            if (!board.isEmpty(row - 1, col - 1)) {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }

            board.setCell(row - 1, col - 1, currentPlayer.getSymbol());
            switchPlayer();
            return true;

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public String checkGameState() {
        if (board.hasWinner('X')) return "X wins";
        if (board.hasWinner('O')) return "O wins";
        if (board.isFull()) return "Draw";
        return "Game not finished";
    }
}


class Board {
    private final Cell[][] grid = new Cell[3][3];

    public Board() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = new Cell();
    }

    public void print() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j].getValue() + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isEmpty(int row, int col) {
        return grid[row][col].isEmpty();
    }

    public void setCell(int row, int col, char symbol) {
        grid[row][col].setValue(symbol);
    }

    public boolean isFull() {
        for (Cell[] row : grid)
            for (Cell c : row)
                if (c.isEmpty())
                    return false;
        return true;
    }

    public boolean hasWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].getValue() == symbol &&
                    grid[i][1].getValue() == symbol &&
                    grid[i][2].getValue() == symbol)
                return true;

            if (grid[0][i].getValue() == symbol &&
                    grid[1][i].getValue() == symbol &&
                    grid[2][i].getValue() == symbol)
                return true;
        }

        if (grid[0][0].getValue() == symbol &&
                grid[1][1].getValue() == symbol &&
                grid[2][2].getValue() == symbol)
            return true;

        return grid[0][2].getValue() == symbol &&
                grid[1][1].getValue() == symbol &&
                grid[2][0].getValue() == symbol;
    }
}


class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}


class Cell {
    private char value;

    public Cell() {
        this.value = ' ';
    }

    public boolean isEmpty() {
        return value == ' ';
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
