import java.util.Scanner;
import java.util.ArrayList;

public class PatternMatchHashing {
    private static final int PRIME = 101;
    private static final int BASE = 256;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        scanner.close();

        ArrayList<Integer> result = rabinKarpSearch(text, pattern);
        System.out.println(result);
    }

    public static ArrayList<Integer> rabinKarpSearch(String text, String pattern) {
        ArrayList<Integer> matches = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            return matches;
        }

        long patternHash = 0;
        long textHash = 0;
        long h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * BASE) % PRIME;
        }

        for (int i = 0; i < m; i++) {
            patternHash = (BASE * patternHash + pattern.charAt(i)) % PRIME;
            textHash = (BASE * textHash + text.charAt(i)) % PRIME;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (isMatch(text, pattern, i)) {
                    matches.add(i);
                }
            }

            if (i < n - m) {
                textHash = (BASE * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % PRIME;
                if (textHash < 0) {
                    textHash += PRIME;
                }
            }
        }

        return matches;
    }

    private static boolean isMatch(String text, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
