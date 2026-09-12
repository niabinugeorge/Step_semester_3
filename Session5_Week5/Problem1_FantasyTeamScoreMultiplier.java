import java.util.Arrays;


public class Problem1_FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));

        System.out.println("\nTest Case 2:");
        double[] scores2 = {20, 45, 60, 15, 80};
        applyMultipliers(scores2, 2, 4);
        System.out.println(Arrays.toString(scores2));
    }
}
