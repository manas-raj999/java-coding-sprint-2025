import java.util.Scanner;
import java.util.HashSet;

public class JewelStonesCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String jewels = scanner.nextLine();
        String stones = scanner.nextLine();
        scanner.close();

        int jewelCount = countJewels(jewels, stones);
        System.out.println(jewelCount);
    }

    public static int countJewels(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();

        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }
}
