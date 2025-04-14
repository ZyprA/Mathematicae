package integration;

import java.util.function.Function;

public class SimpsonMethod implements NumericalMethods {
    @Override
    public double integrate(Function<Double, Double> function, double a, double b) {
        // シンプソン法による積分処理
        int n = 1000; // 分割数
        double h = (b - a) / n;
        double sum = function.apply(a) + function.apply(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 0) {
                sum += 2 * function.apply(x);
            } else {
                sum += 4 * function.apply(x);
            }
        }
        return sum * h / 3;
    }
}
