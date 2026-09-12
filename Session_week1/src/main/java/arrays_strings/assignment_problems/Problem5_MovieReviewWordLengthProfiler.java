package arrays_strings.assignment_problems;

import java.util.Scanner;
public class Problem5_MovieReviewWordLengthProfiler {
    static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Review is empty.");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a movie review (or press Enter to skip): ");
        String customReview = sc.nextLine();
        if (!customReview.isEmpty()) {
            classifyWordLengths(customReview);
        }
        sc.close();
    }
}
