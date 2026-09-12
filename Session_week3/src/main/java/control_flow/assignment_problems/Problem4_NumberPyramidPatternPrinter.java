package control_flow.assignment_problems;

import java.util.Scanner;

/**
 * Level 3 - P1: Number Pyramid Pattern Printer
 *
 * Prints a numeric pyramid where each row prints its row number that
 * many times, using nested for loops.
 */
public class Problem4_NumberPyramidPatternPrinter {

    /**
     * Prints a pyramid with N rows. Row i prints the number i, i times,
     * separated by spaces.
     *
     * @param n the number of rows
     */
    static void printNumberPyramid(int n) {
        for (int row = 1; row <= n; row++) {
            StringBuilder line = new StringBuilder();

            for (int col = 1; col <= row; col++) {
                line.append(row);
                if (col < row) {
                    line.append(" ");
                }
            }

            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        // Sample Input -> n = 4
        // 1
        // 2 2
        // 3 3 3
        // 4 4 4 4
        System.out.println("Test Case 1:");
        printNumberPyramid(4);

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number of rows for the pyramid (or 0 to skip): ");
        int customRows = sc.hasNextInt() ? sc.nextInt() : 0;
        if (customRows > 0) {
            printNumberPyramid(customRows);
        }
        sc.close();
    }
}
