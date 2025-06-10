import java.util.*;

public class CrystalWarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] crystals = new int[n];

        for (int i = 0; i < n; i++) {
            crystals[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Arrays.sort(crystals);

        int bestSum = crystals[0] + crystals[1] + crystals[2];
        int minDiff = Math.abs(target - bestSum);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = crystals[i] + crystals[left] + crystals[right];
                int diff = Math.abs(target - sum);

                if (diff < minDiff || (diff == minDiff && sum > bestSum)) {
                    bestSum = sum;
                    minDiff = diff;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(bestSum);
    }
}
