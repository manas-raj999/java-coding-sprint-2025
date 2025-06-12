import java.util.*;

public class FestivalBanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new int[] { entry.getKey(), entry.getValue() });
        }

        StringBuilder result = new StringBuilder();
        int[] prev = new int[] { -1, 0 };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (prev[1] > 0) {
                pq.offer(prev);
            }

            result.append((char) current[0]);
            current[1]--;
            prev = current;
        }

        if (result.length() == s.length()) {
            System.out.println(result.toString());
        } else {
            System.out.println("");
        }
    }
}
