package arrays.assignment_problems;

import java.util.Scanner;

/**
 * L3: Contains Duplicate
 *
 * Checks whether any value appears more than once in an array, using a
 * brute-force nested-loop pairwise comparison with early exit.
 */
public class Problem3_ContainsDuplicate {

    /**
     * Checks whether the array contains any duplicate values.
     *
     * @param nums array of integers
     * @return true if any value appears at two different positions
     */
    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Early exit — a duplicate was found
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample Input 1 -> true
        System.out.println("Test Case 1:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

        // Sample Input 2 -> false
        System.out.println("Test Case 2:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number of elements to try your own input (or 0 to skip): ");
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        if (n > 0) {
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " numbers:");
            for (int i = 0; i < n; i++) {
                customNums[i] = sc.nextInt();
            }
            System.out.println(containsDuplicate(customNums));
        }
        sc.close();
    }
}
