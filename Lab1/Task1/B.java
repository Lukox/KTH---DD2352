import java.util.Scanner;
import java.io.IOException;

public class B {

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

        int n = 1;
        while (true) {
            long startTime = System.currentTimeMillis();
            double result = coins(n);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            System.out.println("n = " + n + ", Time: " + time + "ms");
            if (time > 1000) { // Break the loop if time exceeds 1 second
                break;
            }
            n++;
        }

    }
}