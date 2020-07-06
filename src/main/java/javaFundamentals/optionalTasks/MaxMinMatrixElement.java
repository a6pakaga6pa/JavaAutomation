package javaFundamentals.optionalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

public class MaxMinMatrixElement {
    public static void main(String[] args) {
        int[][] matrix = fillMatrix();
        System.out.println("Current matrix:");
        printMatrix(matrix);
        System.out.println();

        System.out.println("Max number in matrix is: " + findMaxElement(matrix));
        int[] coordinates = findMinElement(matrix);
        System.out.println("Min number in matrix is: " + "[" + coordinates[0] + "]" + "[" + coordinates[1] + "] "
                + matrix[coordinates[0]][coordinates[1]]);

        System.out.println();
        matrix = deleteLineAndRow(matrix, coordinates[0], coordinates[1]);
        System.out.println("Matrix without line and row of min element:");
        printMatrix(matrix);
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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

    public static int findMaxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] >= max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static int[] findMinElement(int[][] matrix) {
        int x = 0;
        int y = 0;
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] <= min) {
                    min = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public static int[][] deleteLineAndRow(int[][] matrix, int x, int y){
        int[][] newMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i < x && j < y) {
                    newMatrix[i][j] = matrix[i][j];
                } else if(i > x && j > y) {
                    newMatrix[i - 1][j - 1] = matrix[i][j];
                } else if(i > x && j < y) {
                    newMatrix[i - 1][j] = matrix[i][j];
                } else if(i < x && j > y) {
                    newMatrix[i][j - 1] = matrix[i][j];
                }

            }
        }
        return newMatrix;
    }

}
