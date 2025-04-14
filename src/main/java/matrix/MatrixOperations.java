package matrix;

public interface MatrixOperations {
    Matrix add(Matrix other);
    Matrix multiply(Matrix other);
    Matrix transpose();
    Matrix inverse();
}

