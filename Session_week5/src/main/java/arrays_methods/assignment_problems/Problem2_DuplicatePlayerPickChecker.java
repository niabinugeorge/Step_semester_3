package arrays_methods.assignment_problems;

/**
 * Problem 2 (Easy): Duplicate Player Pick Checker
 *
 * Scans a fantasy lineup for a repeated player name using plain nested
 * loops (no Collections), reporting the first duplicate found.
 */
public class Problem2_DuplicatePlayerPickChecker {

    /**
     * Finds the first duplicate player name in the lineup, comparing
     * each name only against the names that come after it.
     *
     * @param playerNames the submitted lineup of player names
     * @return "Duplicate Found: X" for the first duplicate, or
     *         "No Duplicates Found" if every name is unique
     */
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Duplicate Found: Kohli
        System.out.println("Test Case 1:");
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));

        // Sample Input 2 -> No Duplicates Found
        System.out.println("Test Case 2:");
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));
    }
}
