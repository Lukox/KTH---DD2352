import java.util.Scanner;
import java.io.IOException;

public class E {

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