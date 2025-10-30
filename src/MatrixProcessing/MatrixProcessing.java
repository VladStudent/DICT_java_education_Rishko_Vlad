package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addMatrices(scanner);
                case 2 -> multiplyByConstant(scanner);
                case 3 -> multiplyMatrices(scanner);
                case 4 -> transposeMatrix(scanner);
                case 5 -> calculateDeterminant(scanner);
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                1. Add matrices
                2. Multiply matrix by a constant
                3. Multiply matrices
                4. Transpose matrix
                5. Calculate a determinant
                0. Exit""");
        System.out.print("Your choice: > ");
    }

    // --- Addition ---
    private static void addMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        double[][] m1 = readMatrix(scanner, r1, c1, "first");

        System.out.print("Enter size of second matrix: > ");
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        double[][] m2 = readMatrix(scanner, r2, c2, "second");

        if (r1 != r2 || c1 != c2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    // --- Multiply by constant ---
    private static void multiplyByConstant(Scanner scanner) {
        System.out.print("Enter size of matrix: > ");
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        double[][] matrix = readMatrix(scanner, r, c, "");

        System.out.print("Enter constant: > ");
        double k = scanner.nextDouble();

        double[][] result = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = matrix[i][j] * k;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    // --- Multiply matrices ---
    private static void multiplyMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        double[][] m1 = readMatrix(scanner, r1, c1, "first");

        System.out.print("Enter size of second matrix: > ");
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        double[][] m2 = readMatrix(scanner, r2, c2, "second");

        if (c1 != r2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    // --- Transpose ---
    private static void transposeMatrix(Scanner scanner) {
        System.out.println("""
                1. Main diagonal
                2. Side diagonal
                3. Vertical line
                4. Horizontal line""");
        System.out.print("Your choice: > ");
        int option = scanner.nextInt();

        System.out.print("Enter matrix size: > ");
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        double[][] matrix = readMatrix(scanner, r, c, "");

        double[][] result = new double[c][r];

        switch (option) {
            case 1 -> { // main diagonal
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        result[j][i] = matrix[i][j];
            }
            case 2 -> { // side diagonal
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        result[c - 1 - j][r - 1 - i] = matrix[i][j];
            }
            case 3 -> { // vertical line
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        result[i][c - 1 - j] = matrix[i][j];
            }
            case 4 -> { // horizontal line
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        result[r - 1 - i][j] = matrix[i][j];
            }
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    // --- Determinant ---
    private static void calculateDeterminant(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (n != m) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] matrix = readMatrix(scanner, n, m, "");
        double det = determinant(matrix);
        System.out.println("The result is:");
        System.out.println((det % 1 == 0) ? (int) det : det);
    }

    // Recursive determinant
    private static double determinant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1)
            return matrix[0][0];
        if (n == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col));
        }
        return det;
    }

    private static double[][] minor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }

    // --- Helpers ---
    private static double[][] readMatrix(Scanner scanner, int rows, int cols, String name) {
        if (!name.isEmpty()) System.out.println("Enter " + name + " matrix:");
        else System.out.println("Enter matrix:");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = scanner.nextDouble();
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                if (val % 1 == 0)
                    System.out.print((int) val + " ");
                else
                    System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
