import java.util.Scanner;


public class Problem2_GradeClassifierWithLogicalOperators {

   
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
            
            System.out.println("Grade: D");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        classifyWithAttendance(82, 80);

        // Sample Input 2 -> Detained
        System.out.println("Test Case 2:");
        classifyWithAttendance(91, 60);

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
