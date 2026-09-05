import java.util.Scanner;

public class Problem5_GuessTheNumberGame {

    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tryCount = 0;
        boolean guessedCorrectly = false;

        while (tryCount < maxTries && !guessedCorrectly) {
            int currentGuess = guesses[tryCount];

            if (currentGuess > secretNumber) {
                System.out.println("Too high");
            } else if (currentGuess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessedCorrectly = true;
                break;
            }

            tryCount++;
        }

        if (!guessedCorrectly) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        
        System.out.println("Test Case 1:");
        guessTheNumber(42, 4, new int[]{20, 60, 42});

        
        System.out.println("\nTest Case 2:");
        guessTheNumber(42, 2, new int[]{10, 15});

        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the secret number (or -1 to skip): ");
        int customSecret = sc.hasNextInt() ? sc.nextInt() : -1;
        if (customSecret != -1) {
            System.out.println("Enter max tries: ");
            int customMaxTries = sc.nextInt();

            int[] customGuesses = new int[customMaxTries];
            System.out.println("Enter " + customMaxTries + " guesses:");
            for (int i = 0; i < customMaxTries; i++) {
                customGuesses[i] = sc.nextInt();
            }

            guessTheNumber(customSecret, customMaxTries, customGuesses);
        }
        sc.close();
    }
}
