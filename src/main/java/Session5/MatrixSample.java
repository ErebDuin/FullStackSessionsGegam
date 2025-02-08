package Session5;

public class MatrixSample {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 5, 4},
                {9, 3, 5},
                {3, 7, 5}
        };

        int[][] rotatedMatrix = rotateMatrixToRight(matrix);
        printMatrix(rotatedMatrix);
    }

    public static int[][] rotateMatrixToRight(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] rotatedMatrix = new int[colCount][rowCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                rotatedMatrix[j][rowCount - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
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
