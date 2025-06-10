import java.util.*;

public class CargoCrates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> unique = new ArrayList<>(freq.keySet());

        unique.sort((a, b) -> {
            int freqA = freq.get(a);
            int freqB = freq.get(b);
            if (freqA != freqB) {
                return freqB - freqA;
            }
            return a - b;
        });

        StringBuilder result = new StringBuilder();
        for (int num : unique) {
            int count = freq.get(num);
            for (int i = 0; i < count; i++) {
                if (result.length() > 0)
                    result.append(" ");
                result.append(num);
            }
        }

        System.out.println(result.toString());
    }
}
