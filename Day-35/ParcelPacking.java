import java.util.*;

public class ParcelPacking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] weights = new int[n];
        int sum = 0;
        int maxWeight = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            sum += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int left = maxWeight;
        int right = sum;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(weights, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean canDivide(int[] weights, int k, int maxSum) {
        int groups = 1;
        int currentSum = 0;

        for (int weight : weights) {
            if (currentSum + weight <= maxSum) {
                currentSum += weight;
            } else {
                groups++;
                currentSum = weight;
                if (groups > k) {
                    return false;
                }
            }
        }

        return true;
    }
}
