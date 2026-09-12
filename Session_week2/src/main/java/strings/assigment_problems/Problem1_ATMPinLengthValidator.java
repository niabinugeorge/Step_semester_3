package strings.assigment_problems;

import java.util.Scanner;

/**
 * Problem 1: ATM PIN Length Validator
 *
 * Checks that a PIN string is exactly 4 digits long. No loop needed —
 * just length() and a single if / else.
 */
public class Problem1_ATMPinLengthValidator {

    /**
     * Checks whether the given PIN is exactly 4 characters long and
     * prints the result.
     *
     * @param pin the PIN string entered by the customer
     */
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Invalid PIN — must be exactly 4 digits.
        System.out.println("Test Case 1:");
        checkPinLength("482");

        // Sample Input 2 -> PIN length OK.
        System.out.println("Test Case 2:");
        checkPinLength("4820");

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a PIN to check (or press Enter to skip): ");
        String customPin = sc.nextLine();
        if (!customPin.isEmpty()) {
            checkPinLength(customPin);
        }
        sc.close();
    }
}
