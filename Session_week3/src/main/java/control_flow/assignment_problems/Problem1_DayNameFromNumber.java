package control_flow.assignment_problems;

import java.util.Scanner;

/**
 * Level 1 - P5: Day Name From Number
 *
 * Converts a weekday number (1 = Monday ... 7 = Sunday) into its name
 * using a switch statement.
 */
public class Problem1_DayNameFromNumber {

    /**
     * Prints the name of the weekday corresponding to the given number.
     * Prints "Invalid day number" for anything outside 1-7.
     *
     * @param dayNumber a number from 1 to 7
     */
    static void printDayName(int dayNumber) {
        switch (dayNumber) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number");
                break;
        }
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Wednesday
        System.out.println("Test Case 1:");
        printDayName(3);

        // Sample Input 2 -> Invalid day number
        System.out.println("Test Case 2:");
        printDayName(9);

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a day number 1-7 to check (or -1 to skip): ");
        int customDay = sc.hasNextInt() ? sc.nextInt() : -1;
        if (customDay != -1) {
            printDayName(customDay);
        }
        sc.close();
    }
}
