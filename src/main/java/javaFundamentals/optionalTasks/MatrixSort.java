package javaFundamentals.optionalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

//1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).

public class MatrixSort {

    public static void main(String[] args) {
        int[][] matrix = fillMatrix();
        System.out.println("Current matrix:");
        printMatrix(matrix);
        System.out.println();

        System.out.println("Sorted by 2-st line");
        sortLine(matrix, 1);
        printMatrix(matrix);
        System.out.println();

        System.out.println("Sorted by 2-st column");
        sortColumn(matrix,1);
        printMatrix(matrix);


    }

    public static int[][] fillMatrix(){
        int[][] matrix = null;
        boolean ok = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter matrix size [x][y] with Enter: ");
        while(!ok) {
            try {
                System.out.print("x = ");
                String x = reader.readLine();
                System.out.print("y = ");
                String y = reader.readLine();
                if (x == null || y == null || x.isEmpty() || y.isEmpty()) {
                    break;
                }
                matrix = new int[Integer.parseInt(x)][Integer.parseInt(y)];
                ok = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Only numbers are possible to enter!");
            }
        }

        int min = -1000;
        int max = 1000;
        for (int i = 0; i < matrix.length; i++) {
            Random random = new Random();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt((max - min) + 1) + min; }
        }
        return matrix;
    }

    public static int[][] sortLine(int[][] matrix, int index) {
        int[] line = matrix[index];
        Arrays.sort(line);
        matrix[index] = line;
        return matrix;
    }

    public static int[][] sortColumn(int[][] matrix, int index) {
        int[] row = new int[matrix.length];
        for (int i = 0; i < row.length; i++) {
            row[i] = matrix[i][index];
        }
        Arrays.sort(row);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index] = row[i];
        }

        //  Arrays.sort(matrix, Comparator.comparingInt(arr -> arr[index]));
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
