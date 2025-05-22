import java.util.Scanner;

public class StockProfitThreshold {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        scanner.close();

        int maxProfit = findMaxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int findMaxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice;

            if (currentProfit >= 2) {
                maxProfit = Math.max(maxProfit, currentProfit);
            }

            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
