package arrays.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem3_ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        printTriplets(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

        System.out.println("Test Case 2:");
        printTriplets(threeSum(new int[]{0, 0, 0}));
    }

    private static void printTriplets(int[][] triplets) {
        for (int[] triplet : triplets) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}
