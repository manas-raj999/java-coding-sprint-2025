import java.util.Scanner;

public class ZigZagMarathonPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n > 10) {
            System.out.println("Abhik's marathon journey intensifies! Let's see his detailed zig-zag pattern:");
        }

        int totalNumbers = 0;
        int maxWidth = n * 4 - 1;

        for (int day = 1; day <= n; day++) {
            StringBuilder line = new StringBuilder();

            if (day % 2 == 1) {
                for (int num = 1; num <= day; num++) {
                    line.append(num);
                    if (num < day) {
                        line.append("   ");
                    }
                    totalNumbers++;
                }
            } else {
                for (int num = day; num >= 1; num--) {
                    line.append(num);
                    if (num > 1) {
                        line.append("   ");
                    }
                    totalNumbers++;
                }
            }

            int lineLength = line.length();
            int padding = (maxWidth - lineLength) / 2;

            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }

            System.out.println(line);
        }

        System.out.println("Total numbers printed: " + totalNumbers);

        scanner.close();
    }
}
