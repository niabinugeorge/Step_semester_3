package arrays_strings.assignment_problems;

import java.util.Scanner;

public class Problem2_TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedChars++;
            } else if (firstMismatchPosition == -1) {
                // Record only the FIRST mismatch (1-based position)
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matchedChars).append("/").append(totalChars);
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPosition == -1) {
            result.append(" | No Mismatches");
        } else {
            char originalChar = original.charAt(firstMismatchPosition - 1);
            char typedChar = typed.charAt(firstMismatchPosition - 1);
            result.append(" | First Mismatch at position ").append(firstMismatchPosition);
            result.append(" ('").append(originalChar).append("' vs '").append(typedChar).append("')");
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("Test Case 2:");
        checkTypingAccuracy("coding", "coding");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter original passage (or press Enter to skip): ");
        String originalInput = sc.nextLine();
        if (!originalInput.isEmpty()) {
            System.out.println("Enter typed text:");
            String typedInput = sc.nextLine();
            checkTypingAccuracy(originalInput, typedInput);
        }
        sc.close();
    }
}
