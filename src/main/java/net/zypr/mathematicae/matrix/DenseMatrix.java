package net.zypr.mathematicae.matrix;

public class DenseMatrix extends Matrix {
    public DenseMatrix(double[][] data) {
        this.data = data;
    }

    @Override
    public double[][] getData() {
        return data;
    }

    @Override
    public int getRows() {
        return data.length;
    }

    @Override
    public int getColumns() {
        return data[0].length;
    }
}
