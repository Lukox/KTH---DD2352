import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class C {

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

        // Getting values for n, a, b, c
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();

        memory = new double[n + 1];
        Arrays.fill(memory, -1);

        // Getting and prinitng result
        double result = coins(n);
        System.out.println(Math.round(result));

    }
}