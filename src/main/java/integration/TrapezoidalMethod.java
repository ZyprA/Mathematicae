package integration;

import java.util.function.Function;

public class TrapezoidalMethod implements NumericalMethods {
    @Override
    public double integrate(Function<Double, Double> function, double a, double b) {
        // トラペゾイド法による積分処理
        int n = 1000; // 分割数
        double h = (b - a) / n;
        double sum = 0.5 * (function.apply(a) + function.apply(b));
        for (int i = 1; i < n; i++) {
            sum += function.apply(a + i * h);
        }
        return sum * h;
    }
}
