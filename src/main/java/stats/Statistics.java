package stats;

public class Statistics {

    public static double mean(double[] data) {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public static double variance(double[] data) {
        double mean = mean(data);
        double sum = 0;
        for (double num : data) {
            sum += Math.pow(num - mean, 2);
        }
        return sum / data.length;
    }

    public static double standardDeviation(double[] data) {
        return Math.sqrt(variance(data));
    }
}
