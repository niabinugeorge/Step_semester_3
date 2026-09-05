import java.util.Scanner;


public class Problem1_ATMPinLengthValidator {

   
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        checkPinLength("482");

        // Sample Input 2 -> PIN length OK.
        System.out.println("Test Case 2:");
        checkPinLength("4820");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a PIN to check (or press Enter to skip): ");
        String customPin = sc.nextLine();
        if (!customPin.isEmpty()) {
            checkPinLength(customPin);
        }
        sc.close();
    }
}
