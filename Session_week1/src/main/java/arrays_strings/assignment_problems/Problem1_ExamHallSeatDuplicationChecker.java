package arrays_strings.assignment_problems;

import java.util.Scanner;


public class Problem1_ExamHallSeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {

        int[] alreadyReported = new int[seatNumbers.length];
        int reportedCount = 0;
        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    // Check if this seat number has already been reported
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < reportedCount; k++) {
                        if (alreadyReported[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }

                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        alreadyReported[reportedCount] = seatNumbers[i];
                        reportedCount++;
                        foundDuplicate = true;
                    }
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.println("Test Case 1:");
        checkDuplicateSeats(seats1);

        System.out.println();

        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.println("Test Case 2:");
        checkDuplicateSeats(seats2);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number of seats to check your own input (or 0 to skip): ");
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        if (n > 0) {
            int[] customSeats = new int[n];
            System.out.println("Enter " + n + " seat numbers:");
            for (int i = 0; i < n; i++) {
                customSeats[i] = sc.nextInt();
            }
            checkDuplicateSeats(customSeats);
        }
        sc.close();
    }
}
