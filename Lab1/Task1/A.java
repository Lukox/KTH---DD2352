import java.util.Scanner;
import java.io.IOException;

public class A {

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

        // Getting values for n, a, b, c
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();

        // Getting and prinitng result
        double result = coins(n);
        System.out.println(Math.round(result));

    }
}