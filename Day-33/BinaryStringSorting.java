import java.util.*;

public class BinaryStringSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zeros++;
        }

        int misplacedOnes = 0;
        int misplacedZeros = 0;

        for (int i = 0; i < zeros; i++) {
            if (s.charAt(i) == '1') {
                misplacedOnes++;
            }
        }

        for (int i = zeros; i < n; i++) {
            if (s.charAt(i) == '0') {
                misplacedZeros++;
            }
        }

        int pairs = Math.min(misplacedOnes, misplacedZeros);
        int remaining = Math.abs(misplacedOnes - misplacedZeros);

        System.out.println(pairs + remaining);
    }
}
