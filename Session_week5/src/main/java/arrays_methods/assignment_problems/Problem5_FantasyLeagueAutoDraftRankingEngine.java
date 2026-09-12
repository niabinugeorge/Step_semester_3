package arrays_methods.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5 (Advanced): Fantasy League Auto-Draft Ranking Engine
 *
 * A Player is draftable if EITHER:
 *   - they clear the experience-only bar (matchesPlayed >= 10), regardless
 *     of fitness — established players qualify on track record alone; OR
 *   - they clear the combined bar for newer players (matchesPlayed >= 5
 *     AND not injured).
 *
 * Draftable players are ranked by battingAverage descending (the value
 * used as each player's "fantasy points" here, since no separate points
 * field is supplied) using Player's own Comparable implementation, so
 * Arrays.sort(...) does all the ranking work with no extra comparator.
 */
public class Problem5_FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public boolean isInjured() {
            return injured;
        }

        /**
         * Ranks players by battingAverage descending, so a plain
         * Arrays.sort(...) produces the highest scorer first.
         */
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Experience-only draft rule for established players: qualifies on
     * track record alone, regardless of current fitness.
     *
     * @param matchesPlayed number of matches the player has played
     * @return true if the player clears the experience-only bar
     */
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Combined rule for newer players: needs reasonable experience AND
     * to be currently fit.
     *
     * @param matchesPlayed number of matches the player has played
     * @param injured       whether the player is currently injured
     * @return true if the player clears the combined bar
     */
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters players down to the draftable ones (matching either
     * isDraftable rule) and ranks them by fantasy points (battingAverage)
     * descending using Player's natural ordering.
     *
     * @param players the full pool of players to consider
     * @return a formatted, ranked string like "1. Name | 2. Name | ..."
     */
    static String draftAndRank(Player[] players) {
        List<Player> draftablePlayers = new ArrayList<>();

        for (Player player : players) {
            boolean qualifiesOnExperience = isDraftable(player.getMatchesPlayed());
            boolean qualifiesOnCombinedRule = isDraftable(player.getMatchesPlayed(), player.isInjured());

            if (qualifiesOnExperience || qualifiesOnCombinedRule) {
                draftablePlayers.add(player);
            }
        }

        Player[] draftableArray = draftablePlayers.toArray(new Player[0]);

        // Player implements Comparable<Player>, so this single call
        // ranks everyone by fantasy points (battingAverage) descending.
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Input -> 1. Rahul | 2. Virat | 3. Dev
        System.out.println("Test Case 1:");
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
