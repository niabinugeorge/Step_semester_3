import java.util.Scanner;


public class Problem4_LibraryISBNNormalizerValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

       
        if (trimmed.length() < 3) {
            return trimmed;
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return publisherCode + remainder;
    }

   
    static String validateAndFormat(String code) {
        // 1. Must be exactly 13 characters
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        String body = code.substring(3); // 10 characters: 4-digit year + 6-digit catalog

        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

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

        System.out.println("Test Case 1:");
        String raw1 = " pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));

        System.out.println("\nTest Case 2:");
        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));

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
