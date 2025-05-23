import java.util.Scanner;

public class MinCalorieSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        int n = scanner.nextInt();
        int[] sessions = new int[n];

        for (int i = 0; i < n; i++) {
            sessions[i] = scanner.nextInt();
        }

        scanner.close();

        int result = minSubArrayLen(target, sessions);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] sessions) {
        int n = sessions.length;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += sessions[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= sessions[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
