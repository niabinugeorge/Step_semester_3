package arrays_strings.class_problems;

public class Problem4_FirstNonRepeatingCharacter {


    static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256]; // Assumes standard ASCII characters

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (frequency[currentChar] == 1) {
                return currentChar;
            }
        }

        return '\0'; // No non-repeating character found
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        printResult("swiss");

        System.out.println("Test Case 2:");
        printResult("aabbcc");
    }

    private static void printResult(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }
}
