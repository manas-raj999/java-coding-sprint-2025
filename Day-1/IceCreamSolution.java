import java.util.Scanner;

public class IceCreamSolution {
    public static boolean canBuyIceCream(int budget, int[] iceCreamPrices) {
        for (int price : iceCreamPrices) {
            if (price == budget) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = scanner.nextInt();

        int n = scanner.nextInt();
        int[] iceCreamPrices = new int[n];

        for (int i = 0; i < n; i++) {
            iceCreamPrices[i] = scanner.nextInt();
        }

        boolean result = canBuyIceCream(budget, iceCreamPrices);
        System.out.println(result);

        scanner.close();
    }
}
