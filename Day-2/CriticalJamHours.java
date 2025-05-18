import java.util.Scanner;

public class CriticalJamHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vehicles = new int[n];

        for (int i = 0; i < n; i++) {
            vehicles[i] = scanner.nextInt();
        }

        int criticalJamHours = 0;

        for (int i = 1; i < n; i++) {
            if (vehicles[i] >= 50 && vehicles[i] > vehicles[i - 1]) {
                criticalJamHours++;
            }
        }

        System.out.println(criticalJamHours);

        scanner.close();
    }
}
