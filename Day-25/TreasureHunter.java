import java.util.*;

public class TreasureHunter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        
        Arrays.sort(stones);
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = stones[i] + stones[left] + stones[right];
                if (sum == target) {
                    System.out.println("true");
                    return;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        System.out.println("false");
    }
}
