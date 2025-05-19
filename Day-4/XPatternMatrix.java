import java.util.Scanner;

public class XPatternMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print(i + 1);
                } else if (i + j == n - 1) {
                    System.out.print(n - i);
                } else {
                    System.out.print("-");
                }

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
