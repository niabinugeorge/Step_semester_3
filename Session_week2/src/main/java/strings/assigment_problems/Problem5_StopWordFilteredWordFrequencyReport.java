package strings.assigment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 *
 * Analyzes word frequency in a feedback paragraph, excluding a fixed
 * list of common stop words, and prints results sorted by count
 * descending.
 */
public class Problem5_StopWordFilteredWordFrequencyReport {

    // Fixed list of filler / stop words to exclude from the report
    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    /**
     * Checks whether the given word is in the stop-word list.
     *
     * @param word the word to check (already lowercase)
     * @return true if the word is a stop word
     */
    private static boolean isStopWord(String word) {
        for (String stopWord : STOP_WORDS) {
            if (stopWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the frequency of each non-stop-word in the feedback text,
     * sorted by count in descending order.
     *
     * @param feedback the feedback paragraph to analyze
     */
    static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip common punctuation
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "");

        // Split on whitespace
        String[] words = cleaned.trim().split("\\s+");

        // Count frequency of each non-stop-word
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count, descending
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        Collections.sort(entries, (e1, e2) -> e2.getValue() - e1.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Sample Input -> great: 2 | mentor: 1 | session: 1 | clear: 1 (order among ties may vary)
        System.out.println("Test Case 1:");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a feedback paragraph (or press Enter to skip): ");
        String customFeedback = sc.nextLine();
        if (!customFeedback.isEmpty()) {
            printFilteredWordFrequency(customFeedback);
        }
        sc.close();
    }
}
