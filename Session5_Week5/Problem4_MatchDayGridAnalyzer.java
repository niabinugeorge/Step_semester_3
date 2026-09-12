 */
public class Problem4_MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int total = 0;
        for (int runs : row) {
            total += runs;
        }
        return (double) total / row.length;
    }

    
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
        System.out.println("Test Case 1:");
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));

        System.out.println("\nTest Case 2:");
        int[][] runsPerOver2 = {
                {6, 6, 6, 6},
                {1, 2},
                {9, 9, 9}
        };
        System.out.println(classifyMatches(runsPerOver2, 6));
    }
}
