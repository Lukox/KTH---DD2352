import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class D {

    public static int a, b, c;
    public static double[] memory;

    // recursive function
    public static double coins(int n) {
        if (n < 0)
            return Double.POSITIVE_INFINITY;
        else if (memory[n] != -1)
            return memory[n];
        else if (n == 0)
            return 0;
        else {
            double tempA = Math.min(n, 1 + coins(n - a));
            double tempB = Math.min(1 + coins(n - b), 1 + coins(n - c));
            double min = Math.min(tempA, tempB);
            memory[n] = min;
            return min;
        }
    }

    public static void main(String[] args) throws IOException {

        a = 5;
        b = 6;
        c = 7;

        int n = 1;
        while (true) {
            memory = new double[n + 1];
            Arrays.fill(memory, -1);
            long startTime = System.nanoTime();
            double result = coins(n);
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.println("n = " + n + ", Time: " + time + "ms");
            if (time > 1000000000) { // Break the loop if time exceeds 1 second
                break;
            }
            n *= 2;
        }

    }
}