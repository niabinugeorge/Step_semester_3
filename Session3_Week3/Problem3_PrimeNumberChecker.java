import java.util.Scanner;


public class Problem3_PrimeNumberChecker {

    
    static void checkPrime(int number) {
        boolean isPrime = true;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break; 
            }
        }

        System.out.println(isPrime ? "Prime" : "Not Prime");
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        checkPrime(17);

        System.out.println("Test Case 2:");
        checkPrime(18);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a number > 1 to check (or 0 to skip): ");
        int customNumber = sc.hasNextInt() ? sc.nextInt() : 0;
        if (customNumber > 1) {
            checkPrime(customNumber);
        }
        sc.close();
    }
}
