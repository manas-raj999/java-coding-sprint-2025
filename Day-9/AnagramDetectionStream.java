import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramDetectionStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logStream = scanner.nextLine();
        String pattern = scanner.nextLine();
        scanner.close();

        ArrayList<Integer> result = findAnagrams(logStream, pattern);
        System.out.println(result);
    }

    public static ArrayList<Integer> findAnagrams(String logStream, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();

        if (logStream.length() < pattern.length()) {
            return result;
        }

        int[] patternCount = new int[26];
        int[] windowCount = new int[26];

        for (char c : pattern.toCharArray()) {
            patternCount[c - 'a']++;
        }

        int windowSize = pattern.length();

        for (int i = 0; i < windowSize; i++) {
            windowCount[logStream.charAt(i) - 'a']++;
        }

        if (Arrays.equals(patternCount, windowCount)) {
            result.add(0);
        }

        for (int i = windowSize; i < logStream.length(); i++) {
            windowCount[logStream.charAt(i) - 'a']++;
            windowCount[logStream.charAt(i - windowSize) - 'a']--;

            if (Arrays.equals(patternCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
