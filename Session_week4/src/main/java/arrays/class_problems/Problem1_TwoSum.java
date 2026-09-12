package arrays.class_problems;

import java.util.Arrays;
import java.util.Scanner;


public class Problem1_TwoSum {


    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result1));

        System.out.println("Test Case 2:");
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result2));

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
