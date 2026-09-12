package arrays.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4_MergeTwoSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0; // pointer into arr1
        int j = 0; // pointer into arr2
        int k = 0; // pointer into result

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        int[] result1 = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(result1));

        System.out.println("Test Case 2:");
        int[] result2 = mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        System.out.println(Arrays.toString(result2));

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter size of first sorted array (or -1 to skip): ");
        int n1 = sc.hasNextInt() ? sc.nextInt() : -1;
        if (n1 >= 0) {
            int[] customArr1 = new int[n1];
            System.out.println("Enter " + n1 + " sorted numbers for array 1:");
            for (int i = 0; i < n1; i++) {
                customArr1[i] = sc.nextInt();
            }

            System.out.println("Enter size of second sorted array: ");
            int n2 = sc.nextInt();
            int[] customArr2 = new int[n2];
            System.out.println("Enter " + n2 + " sorted numbers for array 2:");
            for (int i = 0; i < n2; i++) {
                customArr2[i] = sc.nextInt();
            }

            System.out.println(Arrays.toString(mergeSortedArrays(customArr1, customArr2)));
        }
        sc.close();
    }
}
