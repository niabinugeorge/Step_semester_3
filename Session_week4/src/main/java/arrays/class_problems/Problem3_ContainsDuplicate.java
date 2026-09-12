package arrays.class_problems;

import java.util.Scanner;

public class Problem3_ContainsDuplicate {

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
        System.out.println("Test Case 1:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

        System.out.println("Test Case 2:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));

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
