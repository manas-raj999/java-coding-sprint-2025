import java.util.Scanner;

public class GardenBinaryTrees {
    public static int numTrees(int n) {
        if (n <= 1)
            return 1;

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numTrees(i - 1) * numTrees(n - i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numTrees(n));
        sc.close();
    }
}
