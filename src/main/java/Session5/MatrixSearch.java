package Session5;

import java.util.Random;
import java.util.Scanner;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill the matrix with random numbers
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100); // Random numbers between 0 and 99
            }
        }

        // Print the matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Ask the user for a number to search and replace
        System.out.print("Enter a number to find: ");
        int numberToFind = scanner.nextInt();

        // Search for the number and replace it with -10
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == numberToFind) {
                    matrix[i][j] = -10;
                    found = true;
                }
            }
        }

        if (found) {
            System.out.println("Number " + numberToFind + " found and replaced with -10.");
        } else {
            System.out.println("Number " + numberToFind + " not found in the matrix.");
        }

        // Print the updated matrix
        System.out.println("Updated Matrix:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
