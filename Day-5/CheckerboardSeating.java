import java.util.Scanner;

public class CheckerboardSeating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[][] seatingPlan = new int[n][n];
        int totalStudents = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    seatingPlan[i][j] = 1;
                    totalStudents++;
                } else {
                    seatingPlan[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(seatingPlan[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("Total students seated: " + totalStudents);
    }
}
