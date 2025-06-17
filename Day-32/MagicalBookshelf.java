import java.util.*;

public class MagicalBookshelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numsInput = sc.nextLine().split(" ");
        int[] nums = new int[numsInput.length];

        for (int i = 0; i < numsInput.length; i++) {
            nums[i] = Integer.parseInt(numsInput[i]);
        }

        int target = sc.nextInt();

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                System.out.println(mid);
                return;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
