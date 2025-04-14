package optimizer;

import java.util.function.Function;

public class GradientDescent implements Optimizer {
    private double learningRate;

    public GradientDescent(double learningRate) {
        this.learningRate = learningRate;
    }

    @Override
    public double optimize(Function<Double, Double> function, double initialGuess) {
        double x = initialGuess;
        double epsilon = 1e-6; // 精度
        double maxIterations = 1000; // 最大反復回数
        int iteration = 0;

        while (iteration < maxIterations) {
            double gradient = derivative(function, x); // 数値微分
            double newX = x - learningRate * gradient;

            if (Math.abs(newX - x) < epsilon) {
                break; // 収束
            }
            x = newX;
            iteration++;
        }
        return x; // 最適化された値
    }

    private double derivative(Function<Double, Double> function, double x) {
        double h = 1e-6; // 微小な値
        return (function.apply(x + h) - function.apply(x - h)) / (2 * h); // 中央差分法
    }
}
