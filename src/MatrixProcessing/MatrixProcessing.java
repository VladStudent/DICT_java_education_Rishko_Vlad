package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо першу матрицю A
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int[][] A = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Зчитуємо другу матрицю B
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int[][] B = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        // Перевірка на сумісність
        if (n1 != n2 || m1 != m2) {
            System.out.println("ERROR");
            return;
        }

        // Обчислюємо та виводимо суму
        int[][] C = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // Виводимо результат
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(C[i][j]);
                if (j < m1 - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
