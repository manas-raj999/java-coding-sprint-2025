import java.util.*;

public class PowerToken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokenInput = sc.nextLine().split(" ");
        int[] tokens = new int[tokenInput.length];
        for (int i = 0; i < tokenInput.length; i++) {
            tokens[i] = Integer.parseInt(tokenInput[i]);
        }
        int power = sc.nextInt();

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }

        System.out.println(maxScore);
    }
}
