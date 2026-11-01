package encapsulation.assigment_problems;

/**
 * Problem 3: The Password Checker
 *
 * Accepts a password once, stores it privately and immutably, and only
 * ever reveals a strength rating — never the password itself.
 */
public class Problem3_ThePasswordChecker {

    static class PasswordChecker {
        private final String password; // final: can't change after creation; no getter

        public PasswordChecker(String password) {
            this.password = password;
        }

        /**
         * Rates the password: "Weak" (under 6 characters), "Medium"
         * (6-9 characters), or "Strong" (10+ characters).
         */
        public String getStrength() {
            int length = password.length();

            if (length < 6) {
                return "Weak";
            } else if (length < 10) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker weak = new PasswordChecker("abcd");
        System.out.println("4 characters -> " + weak.getStrength());       // Weak

        PasswordChecker medium = new PasswordChecker("abcdefgh");
        System.out.println("8 characters -> " + medium.getStrength());     // Medium

        PasswordChecker strong = new PasswordChecker("abcdefghijkl");
        System.out.println("12 characters -> " + strong.getStrength());    // Strong

        PasswordChecker tenChars = new PasswordChecker("abcdefghij");
        System.out.println("10 characters -> " + tenChars.getStrength());  // Strong
    }
}
