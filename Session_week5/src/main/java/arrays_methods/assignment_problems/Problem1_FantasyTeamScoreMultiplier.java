package arrays_methods.assignment_problems;

import java.util.Arrays;

/**
 * Problem 1 (Easy): Fantasy Team Score Multiplier
 *
 * Applies a 2x multiplier to the captain's score and a 1.5x multiplier
 * to the vice-captain's score, modifying the original array directly
 * (arrays are passed by reference in Java).
 */
public class Problem1_FantasyTeamScoreMultiplier {

    /**
     * Doubles the captain's score and multiplies the vice-captain's
     * score by 1.5, modifying playerScores in place. All other scores
     * are left untouched.
     *
     * @param playerScores    the lineup's score array (modified directly)
     * @param captainIndex    index of the captain
     * @param viceCaptainIndex index of the vice-captain
     */
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        // Sample Input -> [40.0, 110.0, 30.0, 93.0]
        System.out.println("Test Case 1:");
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));

        // Additional test case
        System.out.println("\nTest Case 2:");
        double[] scores2 = {20, 45, 60, 15, 80};
        applyMultipliers(scores2, 2, 4);
        System.out.println(Arrays.toString(scores2));
    }
}
