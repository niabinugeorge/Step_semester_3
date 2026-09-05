import java.util.Arrays;
import java.util.Scanner;

/**
 * L1: Two Sum
 *
 * Finds the two indices in an array whose values add up to a given
 * target, using a brute-force nested-loop pairwise search.
 */
public class Problem1_TwoSum {

    /**
     * Finds two different indices i, j such that nums[i] + nums[j] equals
     * target. Assumes exactly one valid pair exists.
     *
     * @param nums   array of integers
     * @param target the target sum
     * @return an array {i, j} with the two matching indices
     */
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Per the problem statement, a valid pair is always guaranteed,
        // so this line should never be reached.
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Sample Input 1 -> [0, 1]
        System.out.println("Test Case 1:");
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result1));

        // Sample Input 2 -> [1, 2]
        System.out.println("Test Case 2:");
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result2));

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
            System.out.println("Enter target sum:");
            int customTarget = sc.nextInt();
            System.out.println(Arrays.toString(twoSum(customNums, customTarget)));
        }
        sc.close();
    }
}
