package control_flow.assignment_problems;

import java.util.Scanner;

/**
 * Level 2 - P1: Grade Classifier With Logical Operators
 *
 * Classifies a student's grade based on marks, but only after checking
 * attendance eligibility (75%+) AND minimum marks (40+) using the &&
 * operator. Fails either condition -> "Detained".
 */
public class Problem2_GradeClassifierWithLogicalOperators {

    /**
     * Prints "Detained" if attendance is below 75% or marks are below 40.
     * Otherwise, prints the letter grade based on marks.
     *
     * @param marks      student's marks (0-100)
     * @param attendance student's attendance percentage (0-100)
     */
    static void classifyWithAttendance(int marks, int attendance) {
        boolean isEligible = (attendance >= 75) && (marks >= 40);

        if (!isEligible) {
            System.out.println("Detained");
            return;
        }

        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else {
            // marks is between 40 and 59 here, since isEligible already
            // guarantees marks >= 40
            System.out.println("Grade: D");
        }
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Grade: B
        System.out.println("Test Case 1:");
        classifyWithAttendance(82, 80);

        // Sample Input 2 -> Detained
        System.out.println("Test Case 2:");
        classifyWithAttendance(91, 60);

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter marks and attendance to check (or -1 -1 to skip): ");
        int customMarks = sc.hasNextInt() ? sc.nextInt() : -1;
        int customAttendance = sc.hasNextInt() ? sc.nextInt() : -1;
        if (customMarks != -1 && customAttendance != -1) {
            classifyWithAttendance(customMarks, customAttendance);
        }
        sc.close();
    }
}
