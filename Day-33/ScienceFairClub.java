import java.util.*;

public class ScienceFairClub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int theme = sc.nextInt();
            freq.put(theme, freq.getOrDefault(theme, 0) + 1);
        }

        int uniqueThemes = freq.size();

        if (uniqueThemes < k) {
            System.out.println("NO");
            return;
        }

        List<Integer> counts = new ArrayList<>(freq.values());
        counts.sort(Collections.reverseOrder());

        int stellarThemes = k;
        int novaThemes = k;
        int studentsUsed = 0;

        for (int i = 0; i < k; i++) {
            studentsUsed += counts.get(i);
        }

        int sharedThemes = Math.max(0, stellarThemes + novaThemes - uniqueThemes);

        if (studentsUsed + sharedThemes <= n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
