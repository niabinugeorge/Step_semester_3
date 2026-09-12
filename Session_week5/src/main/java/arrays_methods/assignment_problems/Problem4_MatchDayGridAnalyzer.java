package arrays_methods.assignment_problems;

/**
 * Problem 4 (Intermediate): Match Day Grid Analyzer
 *
 * Analyzes a 2D grid of runs-per-over across matches, classifying each
 * match as "Power Surge" or "Normal" based on its average scoring rate,
 * reusing a single rowAverage() helper for every match.
 */
public class Problem4_MatchDayGridAnalyzer {

    /**
     * Computes the average of a single match's runs-per-over row.
     * This is the ONLY place the average is calculated — it is called
     * once per match from classifyMatches().
     *
     * @param row the runs scored in each over of one match
     * @return the average runs per over for that match
     */
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int runs : row) {
            total += runs;
        }
        return (double) total / row.length;
    }

    /**
     * Classifies every match as "Power Surge" (average >= threshold) or
     * "Normal" (average below threshold).
     *
     * @param runsPerOver 2D array: one row per match, one column per over
     * @param threshold   the minimum average to qualify as "Power Surge"
     * @return a formatted string listing every match's classification
     */
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int matchIndex = 0; matchIndex < runsPerOver.length; matchIndex++) {
            double average = rowAverage(runsPerOver[matchIndex]);
            String classification = (average >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(matchIndex).append(": ").append(classification);

            if (matchIndex < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Input -> Match 0: Normal | Match 1: Power Surge | Match 2: Normal
        System.out.println("Test Case 1:");
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));

        // Additional test case with rows of different lengths
        System.out.println("\nTest Case 2:");
        int[][] runsPerOver2 = {
                {6, 6, 6, 6},
                {1, 2},
                {9, 9, 9}
        };
        System.out.println(classifyMatches(runsPerOver2, 6));
    }
}
