import java.util.Scanner;
import java.io.IOException;

public class B2 {

    public static int a, b, c;

    // recursive function
    public static double coins(int n) {
        if (n < 0)
            return Double.POSITIVE_INFINITY;
        else if (n == 0)
            return 0;
        else {
            double tempA = Math.min(n, 1 + coins(n - a));
            double tempB = Math.min(1 + coins(n - b), 1 + coins(n - c));
            return Math.min(tempA, tempB);
        }

    }

    public static void main(String[] args) throws IOException {

        // Setting values for a, b, c
        a = 5;
        b = 6;
        c = 7;

        int numTrials = 1000;

        for (int n = 1; n <= 100; n *= 2) {
            long minTime = Long.MAX_VALUE;

            for (int i = 0; i < numTrials; i++) {
                long startTime = System.nanoTime();
                double result = coins(n);
                long endTime = System.nanoTime();
                long time = endTime - startTime;

                // Keep track of the minimum time
                minTime = Math.min(minTime, time);
            }

            System.out.println("n = " + n + ", Min Time: " + minTime + "ns");
        }
    }
}