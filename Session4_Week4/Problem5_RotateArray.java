import java.util.Arrays;
import java.util.Scanner;

/**
 * L5: Rotate Array
 *
 * Rotates an array to the right by k positions by computing each
 * element's new position directly and building a new array from scratch.
 */
public class Problem5_RotateArray {

    /**
     * Rotates the array to the right by k positions.
     *
     * @param nums array to rotate
     * @param k    number of positions to rotate right
     * @return a new array containing the rotated values
     */
    static int[] rotateArray(int[] nums, int k) {
        int length = nums.length;

        if (length == 0) {
            return nums;
        }

        // Rotating by the array's own length (or a multiple of it) has no effect
        k = k % length;

        int[] newArray = new int[length];

        for (int i = 0; i < length; i++) {
            int newPosition = (i + k) % length;
            newArray[newPosition] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        // Sample Input 1 -> [5, 6, 7, 1, 2, 3, 4]
        System.out.println("Test Case 1:");
        int[] result1 = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(result1));

        // Sample Input 2 -> [2, 1]
        System.out.println("Test Case 2:");
        int[] result2 = rotateArray(new int[]{1, 2}, 3);
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
            System.out.println("Enter rotation amount k:");
            int customK = sc.nextInt();
            System.out.println(Arrays.toString(rotateArray(customNums, customK)));
        }
        sc.close();
    }
}
