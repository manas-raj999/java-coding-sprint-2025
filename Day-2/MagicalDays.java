import java.util.Scanner;

public class MagicalDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int magicalDays = 0;

        for (int i = 1; i < n - 1; i++) {
            if (scores[i] > scores[i - 1] && scores[i] > scores[i + 1]) {
                magicalDays++;
            }
        }

        System.out.println(magicalDays);

        scanner.close();
    }
}
