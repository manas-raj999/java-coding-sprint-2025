import java.util.Scanner;

public class AliaGrowingBinaryTable {
    public static int findKthBit(int n, int k) {
        if (n == 1)
            return 0;

        int length = (1 << (n - 1));
        int mid = length / 2;

        if (k <= mid) {
            return findKthBit(n - 1, k);
        } else {
            return 1 - findKthBit(n - 1, length - k + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findKthBit(n, k));
        sc.close();
    }
}
