package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Your choice: > ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1 -> addMatrices(scanner);
                case 2 -> multiplyMatrixByConstant(scanner);
                case 3 -> multiplyMatrices(scanner);
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("0. Exit");
    }


    private static void addMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] A = readMatrix(scanner, n1, m1);

        System.out.print("Enter size of second matrix: > ");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] B = readMatrix(scanner, n2, m2);

        if (n1 != n2 || m1 != m2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }


    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.print("Enter size of matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter matrix:");
        double[][] matrix = readMatrix(scanner, n, m);

        System.out.print("Enter constant: > ");
        double k = scanner.nextDouble();

        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] * k;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }


    private static void multiplyMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] A = readMatrix(scanner, n1, m1);

        System.out.print("Enter size of second matrix: > ");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] B = readMatrix(scanner, n2, m2);

        if (m1 != n2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }


    private static double[][] readMatrix(Scanner scanner, int n, int m) {
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(removeTrailingZeros(row[j]));
                if (j < row.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    private static String removeTrailingZeros(double value) {
        if (value == (long) value)
            return String.format("%d", (long) value);
        else
            return String.format("%s", value);
    }
}
