package MatrixProcessing;

import java.util.Scanner;


public class MatrixProcessing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MatrixProcessor processor = new MatrixProcessor(scanner);

        boolean isRunning = true;

        while (isRunning) {

            processor.printMainMenu();

            String choice = scanner.nextLine();
            isRunning = processor.processMainMenuChoice(choice);
        }

        scanner.close();
    }
}


class Matrix {
    int rows;
    int cols;
    double[][] data;


    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }
}


class MatrixProcessor {

    private Scanner scanner;


    public MatrixProcessor(Scanner scanner) {
        this.scanner = scanner;
    }


    public void printMainMenu() {
        System.out.println("\n1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: > ");
    }


    public boolean processMainMenuChoice(String choice) {
        switch (choice) {
            case "1":
                handleAddMatrices();
                break;
            case "2":
                handleMultiplyByConstant();
                break;
            case "3":
                handleMultiplyMatrices();
                break;
            case "4":
                handleTransposeMatrix();
                break;
            case "5":
                handleCalculateDeterminant();
                break;
            case "6":
                handleInverseMatrix();
                break;
            case "0":
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        return true;
    }




    private Matrix readMatrix(String prompt) {
        System.out.print(prompt);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        Matrix matrix = new Matrix(rows, cols);

        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.data[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }
        return matrix;
    }


    private void printResult(Matrix matrix) {
        System.out.println("The result is:");
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.cols; j++) {
                System.out.printf("%8.2f", matrix.data[i][j]);
            }
            System.out.println();
        }
    }


    private void printResult(double value) {
        System.out.println("The result is:");
        System.out.println(value);
    }

    private void handleAddMatrices() {
        Matrix a = readMatrix("Enter size of first matrix: > ");
        Matrix b = readMatrix("Enter size of second matrix: > ");

        if (a.rows != b.rows || a.cols != b.cols) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Matrix result = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                result.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        printResult(result);
    }


    private void handleMultiplyByConstant() {
        Matrix a = readMatrix("Enter size of matrix: > ");

        System.out.print("Enter constant: > ");
        double constant = scanner.nextDouble();
        scanner.nextLine();

        Matrix result = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                result.data[i][j] = a.data[i][j] * constant;
            }
        }
        printResult(result);
    }

    private void handleMultiplyMatrices() {
        Matrix a = readMatrix("Enter size of first matrix: > ");
        Matrix b = readMatrix("Enter size of second matrix: > ");

        if (a.cols != b.rows) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Matrix result = new Matrix(a.rows, b.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                double sum = 0;
                for (int k = 0; k < a.cols; k++) {
                    sum += a.data[i][k] * b.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        printResult(result);
    }


    private void handleTransposeMatrix() {
        System.out.println("\n1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: > ");
        String choice = scanner.nextLine();

        Matrix a = readMatrix("Enter matrix size: > ");
        Matrix result = null;

        switch (choice) {
            case "1": // Главная диагональ
                result = new Matrix(a.cols, a.rows);
                for (int i = 0; i < a.rows; i++) {
                    for (int j = 0; j < a.cols; j++) {
                        result.data[j][i] = a.data[i][j];
                    }
                }
                break;
            case "2": // Побочная диагональ
                result = new Matrix(a.cols, a.rows);
                for (int i = 0; i < a.rows; i++) {
                    for (int j = 0; j < a.cols; j++) {
                        result.data[a.cols - 1 - j][a.rows - 1 - i] = a.data[i][j];
                    }
                }
                break;
            case "3": // Вертикальная линия
                result = new Matrix(a.rows, a.cols);
                for (int i = 0; i < a.rows; i++) {
                    for (int j = 0; j < a.cols; j++) {
                        result.data[i][a.cols - 1 - j] = a.data[i][j];
                    }
                }
                break;
            case "4": // Горизонтальная линия
                result = new Matrix(a.rows, a.cols);
                for (int i = 0; i < a.rows; i++) {
                    for (int j = 0; j < a.cols; j++) {
                        result.data[a.rows - 1 - i][j] = a.data[i][j];
                    }
                }
                break;
            default:
                System.out.println("Invalid transpose choice.");
                return;
        }
        printResult(result);
    }


    private void handleCalculateDeterminant() {
        Matrix a = readMatrix("Enter matrix size: > ");
        if (a.rows != a.cols) {
            System.out.println("The operation cannot be performed. Matrix must be square.");
            return;
        }
        double det = determinant(a.data);
        printResult(det);
    }


    private void handleInverseMatrix() {
        Matrix a = readMatrix("Enter matrix size: > ");
        if (a.rows != a.cols) {
            System.out.println("The operation cannot be performed. Matrix must be square.");
            return;
        }

        double det = determinant(a.data);
        if (det == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return;
        }

        Matrix adjugate = getAdjugateMatrix(a);


        Matrix inverse = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                inverse.data[i][j] = (1.0 / det) * adjugate.data[i][j];
            }
        }

        printResult(inverse);
    }



    private double determinant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * matrix[0][j] * determinant(getMinor(matrix, 0, j));
        }
        return det;
    }


    private double[][] getMinor(double[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        for (int i = 0, newRow = 0; i < n; i++) {
            if (i == rowToRemove) {
                continue;
            }
            for (int j = 0, newCol = 0; j < n; j++) {
                if (j == colToRemove) {
                    continue;
                }
                minor[newRow][newCol++] = matrix[i][j];
            }
            newRow++;
        }
        return minor;
    }


    private Matrix getAdjugateMatrix(Matrix m) {
        int n = m.rows;
        Matrix cofactorMatrix = new Matrix(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] minor = getMinor(m.data, i, j);
                double cofactor = Math.pow(-1, i + j) * determinant(minor);
                cofactorMatrix.data[i][j] = cofactor;
            }
        }

        
        Matrix adjugate = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjugate.data[j][i] = cofactorMatrix.data[i][j];
            }
        }
        return adjugate;
    }
}
