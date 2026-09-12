import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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


        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name;
        }
    }


    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

  
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
