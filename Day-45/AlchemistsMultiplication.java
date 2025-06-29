import java.util.*;

public class AlchemistsMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] crystals = new int[n];
        for (int i = 0; i < n; i++) {
            crystals[i] = sc.nextInt();
        }

        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * crystals[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= crystals[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i < n - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
}
