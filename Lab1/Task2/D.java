package Lab1.Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class D {
    public static int k;
    public static double p;
    public static double[] memory;

    public static double f(int x) {
        if (memory[x] != -1) {
            return memory[x];
        } else if (x == k) {
            return Math.pow(p, k);
        } else if (x < k) {
            return 0;
        } else {
            double temp = f(x - 1) + Math.pow(p, k) * (1 - p) * (1 - f(x - k - 1));
            memory[x] = temp;
            return temp;
        }
    }

    public static void main(String[] args) throws IOException {

        p = 0.99;
        int n = 1;
        while (true) {
            k = n / 2;
            memory = new double[n + 1];
            Arrays.fill(memory, -1);

            long start = System.nanoTime();
            double result = f(n);
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("n = " + n + ", Time: " + time + "ns");
            long minute = 60000000000L;
            if (time > minute) {
                break;
            }
            n *= 2;
        }
    }
}