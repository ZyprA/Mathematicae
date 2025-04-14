package integration;

import java.util.function.Function;

public interface NumericalMethods {
    double integrate(Function<Double,Double> function, double a, double b);
}