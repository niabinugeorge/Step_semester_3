package strings.assigment_problems;

import java.util.Scanner;

/**
 * Problem 2: Word Reversal Encoder
 *
 * Reverses every word in a sentence individually while keeping the word
 * order the same, e.g. "hello club" -> "olleh bulc".
 */
public class Problem2_WordReversalEncoder {

    /**
     * Reverses each word in the given sentence individually, keeping
     * word order intact.
     *
     * @param sentence the sentence to encode (words separated by single spaces)
     * @return the sentence with each word reversed
     */
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Reverse the current word using a loop and StringBuilder
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            result.append(reversedWord);

            // Add a space between words, but not after the last one
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Input -> olleh bulc
        System.out.println("Test Case 1:");
        System.out.println(reverseEachWord("hello club"));

        // Additional test case
        System.out.println("\nTest Case 2:");
        System.out.println(reverseEachWord("java is fun"));

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a sentence to reverse (or press Enter to skip): ");
        String customSentence = sc.nextLine();
        if (!customSentence.isEmpty()) {
            System.out.println(reverseEachWord(customSentence));
        }
        sc.close();
    }
}
