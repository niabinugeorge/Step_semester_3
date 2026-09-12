package control_flow.assignment_problems;

import java.util.Scanner;

/**
 * Level 2 - P5: Prime Number Checker
 *
 * Checks whether a number is prime using a boolean flag and a loop that
 * stops early (break) the moment a divisor is found.
 */
public class Problem3_PrimeNumberChecker {

    /**
     * Checks whether the given number is prime and prints the result.
     *
     * @param number an integer greater than 1
     */
    static void checkPrime(int number) {
        boolean isPrime = true;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break; // Stop checking further — a divisor was found
            }
        }

        System.out.println(isPrime ? "Prime" : "Not Prime");
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Prime
        System.out.println("Test Case 1:");
        checkPrime(17);

        // Sample Input 2 -> Not Prime
        System.out.println("Test Case 2:");
        checkPrime(18);

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a number > 1 to check (or 0 to skip): ");
        int customNumber = sc.hasNextInt() ? sc.nextInt() : 0;
        if (customNumber > 1) {
            checkPrime(customNumber);
        }
        sc.close();
    }
}
