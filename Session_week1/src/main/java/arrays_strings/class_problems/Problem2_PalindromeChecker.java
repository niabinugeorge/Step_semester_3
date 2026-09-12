package arrays_strings.class_problems;


public class Problem2_PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        // Base case: 0 or 1 character remaining is always a palindrome
        if (text.length() <= 1) {
            return true;
        }

        int lastIndex = text.length() - 1;
        if (text.charAt(0) != text.charAt(lastIndex)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, lastIndex));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    private static String describe(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1: \"madam\"");
        printAllApproaches("madam");

        System.out.println("\nTest Case 2: \"hello\"");
        printAllApproaches("hello");
    }

    private static void printAllApproaches(String text) {
        System.out.println("Iterative: " + describe(isPalindromeIterative(text)) +
                " | Recursive: " + describe(isPalindromeRecursive(text)) +
                " | Array Reversal: " + describe(isPalindromeArrayReversal(text)));
    }
}
