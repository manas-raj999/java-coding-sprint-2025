import java.util.Scanner;

public class LongestIncreasingSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] temps = new int[n];

        for (int i = 0; i < n; i++) {
            temps[i] = scanner.nextInt();
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < n; i++) {
            if (temps[i] > temps[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }

        System.out.println(maxLength);

        scanner.close();
    }
}
