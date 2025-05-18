import java.util.Scanner;

public class ArcheryPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int goodShots = 0;
        int missedShots = 0;

        for (int score : scores) {
            if (score >= 7) {
                goodShots++;
            } else {
                missedShots++;
            }
        }

        System.out.println(goodShots + " " + missedShots);

        scanner.close();
    }
}
