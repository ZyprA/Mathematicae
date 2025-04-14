package net.zypr.mathmaticae.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {
    @Test
    void testMean() {
        double[] values = {1, 2, 3, 4, 5};
        assertEquals(3.0, Statistics.mean(values), 0.001);
    }
}
