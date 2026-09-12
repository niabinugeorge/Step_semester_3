package arrays_methods.assignment_problems;

/**
 * Problem 3 (Intermediate): Top Performer Tracker
 *
 * Finds the minimum, maximum, and spread of a scoreboard in a single
 * pass through the array, without sorting.
 */
public class Problem3_TopPerformerTracker {

    /**
     * Finds the minimum, maximum, and spread (max - min) of the given
     * scores in a single pass.
     *
     * @param scores array of weekly scores
     * @return a formatted string: "Min: X | Max: Y | Spread: Z"
     */
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        // Sample Input -> Min: 33 | Max: 90 | Spread: 57
        System.out.println("Test Case 1:");
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));

        // Additional test case
        System.out.println("\nTest Case 2:");
        System.out.println(findMinMaxSpread(new int[]{10, 10, 10}));
    }
}
