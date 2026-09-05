import java.util.Scanner;

/**
 * L2: Best Time to Buy and Sell Stock
 *
 * Finds the maximum profit achievable from a single buy followed by a
 * single later sell, using one left-to-right pass while tracking the
 * lowest price seen so far.
 */
public class Problem2_BestTimeToBuyAndSellStock {

    /**
     * Computes the maximum possible profit from buying on one day and
     * selling on a later day. Returns 0 if no profitable trade exists.
     *
     * @param prices array of daily stock prices
     * @return the maximum profit
     */
    static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int lowestPriceSoFar = prices[0];
        int maxProfitSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestPriceSoFar;

            if (profitIfSoldToday > maxProfitSoFar) {
                maxProfitSoFar = profitIfSoldToday;
            }

            if (prices[i] < lowestPriceSoFar) {
                lowestPriceSoFar = prices[i];
            }
        }

        return maxProfitSoFar;
    }

    public static void main(String[] args) {
        // Sample Input 1 -> 5
        System.out.println("Test Case 1:");
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        // Sample Input 2 -> 0
        System.out.println("Test Case 2:");
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number of days to try your own input (or 0 to skip): ");
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        if (n > 0) {
            int[] customPrices = new int[n];
            System.out.println("Enter " + n + " daily prices:");
            for (int i = 0; i < n; i++) {
                customPrices[i] = sc.nextInt();
            }
            System.out.println(maxProfit(customPrices));
        }
        sc.close();
    }
}
