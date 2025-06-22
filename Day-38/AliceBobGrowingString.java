import java.util.Scanner;

public class AliceBobGrowingString {
    public static char findKthCharacter(int k) {
        String current = "a";

        while (current.length() < k) {
            StringBuilder next = new StringBuilder();
            for (char c : current.toCharArray()) {
                next.append((char) ((c - 'a' + 1) % 26 + 'a'));
            }
            current = current + next.toString();
        }

        return Character.toUpperCase(current.charAt(k - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(findKthCharacter(k));
        sc.close();
    }
}
