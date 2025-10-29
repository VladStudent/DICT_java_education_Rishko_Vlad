package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe initialized!");
    }
}

class Cell {
    private char value;

    public Cell() {
        this.value = ' ';
    }

    public boolean isEmpty() { return value == ' '; }
    public char getValue() { return value; }
    public void setValue(char value) { this.value = value; }
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
}
