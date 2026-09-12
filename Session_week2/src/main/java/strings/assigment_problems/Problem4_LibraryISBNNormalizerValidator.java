package strings.assigment_problems;

import java.util.Scanner;

/**
 * Problem 4: Library ISBN Normalizer & Validator
 *
 * Normalizes a raw ISBN-style code (trims spaces, uppercases the 3-letter
 * publisher prefix) and validates it: exactly 13 characters — 3 letters
 * (publisher code) + 4 digits (year) + 6 digits (catalog number).
 */
public class Problem4_LibraryISBNNormalizerValidator {

    /**
     * Normalizes a raw code: trims leading/trailing spaces, then
     * uppercases only the first 3 characters (publisher code) using
     * substring() + concatenation, leaving the rest untouched.
     *
     * @param raw the raw scanned code, possibly with stray spaces
     * @return the normalized code
     */
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        // Not enough characters to even have a publisher code —
        // return as-is so validateAndFormat() can report the length issue.
        if (trimmed.length() < 3) {
            return trimmed;
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return publisherCode + remainder;
    }

    /**
     * Validates a normalized code and, if valid, builds a formatted
     * display line. If invalid, returns the specific reason.
     *
     * @param code the normalized code to validate
     * @return a formatted display line, or an "Invalid: ..." reason
     */
    static String validateAndFormat(String code) {
        // 1. Must be exactly 13 characters
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        String body = code.substring(3); // 10 characters: 4-digit year + 6-digit catalog

        // 2. First 3 characters must all be letters
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Remaining 10 characters must all be digits
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: year/catalog body must be 10 digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4, 10);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] ");
        display.append("YEAR: ").append(year).append(" | ");
        display.append("CATALOG: ").append(catalog);

        return display.toString();
    }

    public static void main(String[] args) {
        // Sample Input 1 -> [PEN] YEAR: 2026 | CATALOG: 004251
        System.out.println("Test Case 1:");
        String raw1 = " pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));

        // Sample Input 2 -> Invalid: publisher code must be 3 letters
        System.out.println("\nTest Case 2:");
        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a raw code to normalize & validate (or press Enter to skip): ");
        String customRaw = sc.nextLine();
        if (!customRaw.isEmpty()) {
            String normalizedCustom = normalizeCode(customRaw);
            System.out.println(validateAndFormat(normalizedCustom));
        }
        sc.close();
    }
}
