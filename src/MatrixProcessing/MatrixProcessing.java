package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо розміри матриці
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Зчитуємо матрицю
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Зчитуємо константу
        int k = scanner.nextInt();

        // Множимо матрицю на константу
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] *= k;
            }
        }

        // Виводимо результат
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
                if (j < m - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}