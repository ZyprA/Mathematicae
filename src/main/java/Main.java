import matrix.DenseMatrix;
import matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new DenseMatrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        Matrix matrix2 = new DenseMatrix(new double[][]{
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        });
        Matrix result = matrix1.add(matrix2);
        System.out.println("Result of addition:");
        printMatrix(result);
    }

    private static void printMatrix(Matrix matrix) {
        double[][] data = matrix.getData();
        for (double[] row : data) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
