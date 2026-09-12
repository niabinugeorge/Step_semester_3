package arrays.class_problems;

import java.util.Scanner;

public class Problem2_BestTimeToBuyAndSellStock {


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
        System.out.println("Test Case 1:");
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println("Test Case 2:");
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

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
