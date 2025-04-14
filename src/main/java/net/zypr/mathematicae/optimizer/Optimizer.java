package net.zypr.mathematicae.optimizer;

import java.util.function.Function;

public interface Optimizer {
    double optimize(Function<Double, Double> function, double initialGuess);
}
