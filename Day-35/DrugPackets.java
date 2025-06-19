import java.util.*;

public class DrugPackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int highness = sc.nextInt();
            freq.put(highness, freq.getOrDefault(highness, 0) + 1);
        }

        int maxFrequency = 0;
        for (int count : freq.values()) {
            maxFrequency = Math.max(maxFrequency, count);
        }

        System.out.println(maxFrequency);
    }
}
