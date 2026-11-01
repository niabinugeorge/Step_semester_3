package encapsulation.class_problems;

/**
 * Problem 4: The Locker Code
 *
 * The combination can be changed (given the current code) but never
 * read back — there is deliberately no getter.
 */
public class Problem4_TheLockerCode {

    static class Locker {
        private final int lockerNumber;
        private String code; // private, no getter

        public Locker(int lockerNumber, String code) {
            this.lockerNumber = lockerNumber;
            this.code = code;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }

        /**
         * Changes the code only if currentCode matches; otherwise the
         * change is rejected and nothing is touched.
         *
         * @return true if the code was changed
         */
        public boolean changeCode(String currentCode, String newCode) {
            if (!code.equals(currentCode)) {
                return false; // check first — do nothing else on failure
            }
            code = newCode;
            return true;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        System.out.println("changeCode(\"1234\", \"5678\") -> "
                + (l.changeCode("1234", "5678") ? "success" : "rejected"));

        System.out.println("changeCode(\"0000\", \"9999\") -> "
                + (l.changeCode("0000", "9999") ? "success" : "rejected"));

        // The code can't be read, so prove it is still "5678" by using it:
        System.out.println("changeCode(\"5678\", \"4321\") -> "
                + (l.changeCode("5678", "4321") ? "success (code was still 5678)" : "rejected"));
    }
}
