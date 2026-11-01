package encapsulation.class_problems;

/**
 * Problem 2: The Quiz Scorecard
 *
 * Stores each answer's result in a private array and only reveals the
 * total score — never the raw results.
 */
public class Problem2_TheQuizScorecard {

    static class Scorecard {
        private final boolean[] results;
        private int recorded; // how many answers recorded so far

        public Scorecard(int totalQuestions) {
            this.results = new boolean[totalQuestions]; // length fixed at creation
            this.recorded = 0;
        }

        public void recordAnswer(boolean correct) {
            if (recorded >= results.length) {
                System.out.println("All " + results.length + " answers already recorded — ignored.");
                return;
            }
            results[recorded] = correct;
            recorded++;
        }

        /** Computed from the private array on request; the array itself is never exposed. */
        public int getScore() {
            int score = 0;
            for (int i = 0; i < recorded; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("getScore() -> " + sc.getScore()); // 3

        sc.recordAnswer(true); // extra answer — ignored
        System.out.println("getScore() after extra answer -> " + sc.getScore()); // still 3
    }
}
