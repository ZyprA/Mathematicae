package net.zypr.mathematicae.matrix;

public abstract class Matrix implements MatrixOperations {
    protected double[][] data;

    public abstract double[][] getData();
    public abstract int getRows();
    public abstract int getColumns();

    @Override
    public Matrix add(Matrix other) {
        int rows = getRows();
        int columns = getColumns();
        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = this.data[i][j] + other.getData()[i][j];
            }
        }

        return new DenseMatrix(result);
    }

    @Override
    public Matrix multiply(Matrix other) {
        int rows = getRows();
        int columns = other.getColumns();
        int innerDim =  getColumns();

        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = 0;
                for (int k = 0; k < innerDim; k++) {
                    result[i][j] += this.data[i][k] * other.getData()[k][j];
                }
            }
        }

        return new DenseMatrix(result);
    }

    @Override
    public Matrix transpose() {
        int rows = getRows();
        int columns = getColumns();
        double[][] result = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = this.data[i][j];
            }
        }
        return new DenseMatrix(result);
    }

    @Override
    public Matrix inverse() {
        int rows = getRows();
        int columns = getColumns();

        if (rows != columns) {
            throw new IllegalArgumentException("matrix.Matrix must be square to compute inverse.");
        }

        double[][] result = new double[rows][columns];
        double determinant = determinant(this.data);

        if (determinant == 0) {
            throw new IllegalArgumentException("matrix.Matrix is singular and cannot be inverted.");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = cofactor(this.data, i, j) / determinant;
            }
        }

        return new DenseMatrix(result);
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
        for (int i = 0; i < n; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
        }
        return det;
    }

    private double[][] minor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row && j != col) {
                    minor[i < row ? i : i - 1][j < col ? j : j - 1] = matrix[i][j];
                }
            }
        }
        return minor;
    }

    private double cofactor(double[][] matrix, int row, int col) {
        return Math.pow(-1, row + col) * determinant(minor(matrix, row, col));
    }
}
