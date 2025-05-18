import java.util.Scanner;

public class OverstockedWarehouses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        int[][] stock = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                stock[i][j] = scanner.nextInt();
            }
        }

        int overstockedCount = 0;

        for (int i = 0; i < r; i++) {
            int productTypesOverThreshold = 0;

            for (int j = 0; j < c; j++) {
                if (stock[i][j] >= 100) {
                    productTypesOverThreshold++;
                }
            }

            if (productTypesOverThreshold >= 3) {
                overstockedCount++;
            }
        }

        System.out.println(overstockedCount);

        scanner.close();
    }
}
