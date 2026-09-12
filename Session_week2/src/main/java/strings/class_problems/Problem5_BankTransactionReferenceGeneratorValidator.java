package strings.class_problems;

public class Problem5_BankTransactionReferenceGeneratorValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;
        }

        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return bankCode + remainder;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        String body = reference.substring(3); // 11 characters: 6-digit date + 5-digit sequence

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: date/sequence body must be 11 digits";
            }
        }

        String date = body.substring(0, 6);
        String sequence = body.substring(6, 11);

        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 6);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] ");
        display.append("DATE: ").append(day).append("/").append(month).append("/").append(year).append(" | ");
        display.append("SEQ: ").append(sequence);

        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        String raw1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(normalized1));

        System.out.println("\nTest Case 2:");
        String raw2 = "12F03022600042";
        String normalized2 = normalizeReference(raw2);
        System.out.println(validateAndFormat(normalized2));
    }
}
