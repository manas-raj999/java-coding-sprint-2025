import java.util.*;

public class Stream {
    public static String firstUniqueChar(String s) {
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            queue.offer(c);

            while (!queue.isEmpty() && count[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(firstUniqueChar(s));
    }
}
