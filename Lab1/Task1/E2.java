import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class E2 {

    public static int a, b, c;

    // iterative function
    public static double coins(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = n;
        }

        for (int i = 1; i <= n; i++) {
            // copper coins
            if (i >= 1) {
                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            }

            // silver coins
            if (i >= a) {
                arr[i] = Math.min(arr[i], arr[i - a] + 1);
            }

            // gold coins
            if (i >= b) {
                arr[i] = Math.min(arr[i], arr[i - b] + 1);
            }

            // platinum coins
            if (i >= c) {
                arr[i] = Math.min(arr[i], arr[i - c] + 1);
            }
        }

        return arr[n];
    }

    public static void main(String[] args) throws IOException {

        a = 5;
        b = 6;
        c = 7;

        int n = 1;
        while (true) {
            long startTime = System.nanoTime();
            double result = coins(n);
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.println("n = " + n + ", Time: " + time + "ns");
            if (time > 1000000000) { // Break the loop if time exceeds 1 second
                break;
            }
            n *= 2;
        }
    }
}