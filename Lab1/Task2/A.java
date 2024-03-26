package Lab1.Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class A {
    public static int k;
    public static double p;
    public static double[][] memory;

    public static double f(int x, int y) {
        if (memory[x][y] != -1) {
            return memory[x][y];
        } else if (y == 0) {
            return 1.0;
        } else if (x == 0 && y > 0) {
            return 0.0;
        } else {
            double temp = p * f(x - 1, y - 1) + (1 - p) * f(x - 1, k);
            memory[x][y] = temp;
            return temp;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        k = s.nextInt();
        p = s.nextDouble();

        memory = new double[n + 1][k + 1];

        for (double[] row : memory)
            Arrays.fill(row, -1);

        double result = f(n, k);
        System.out.println(result);
    }
}