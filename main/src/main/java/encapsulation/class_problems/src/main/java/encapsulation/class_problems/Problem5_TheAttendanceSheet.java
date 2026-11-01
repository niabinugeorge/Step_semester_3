package encapsulation.class_problems;

/**
 * Problem 5: The Attendance Sheet
 *
 * Stores present students in a private array; only reveals a count and
 * a yes/no lookup — never the full list. Duplicate names aren't counted.
 */
public class Problem5_TheAttendanceSheet {

    static class AttendanceSheet {
        private final String[] presentNames;
        private int presentCount;

        public AttendanceSheet(int maxClassSize) {
            this.presentNames = new String[maxClassSize];
            this.presentCount = 0;
        }

        public void markPresent(String name) {
            if (isPresent(name)) {
                return; // already marked — don't count twice
            }
            if (presentCount >= presentNames.length) {
                System.out.println("Class is full — cannot mark \"" + name + "\".");
                return;
            }
            presentNames[presentCount] = name;
            presentCount++;
        }

        public int getPresentCount() {
            return presentCount;
        }

        public boolean isPresent(String name) {
            for (int i = 0; i < presentCount; i++) {
                if (presentNames[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate — ignored

        System.out.println("getPresentCount() -> " + sheet.getPresentCount()); // 2
        System.out.println("isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));   // true
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen")); // false
    }
}
