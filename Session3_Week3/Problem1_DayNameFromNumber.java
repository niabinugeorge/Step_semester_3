import java.util.Scanner;

public class Problem1_DayNameFromNumber {

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

        System.out.println("Test Case 2:");
        printDayName(9);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a day number 1-7 to check (or -1 to skip): ");
        int customDay = sc.hasNextInt() ? sc.nextInt() : -1;
        if (customDay != -1) {
            printDayName(customDay);
        }
        sc.close();
    }
}
