import java.util.Scanner;


public class Problem2_WordReversalEncoder {

  
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Reverse the current word using a loop and StringBuilder
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        System.out.println(reverseEachWord("hello club"));

        System.out.println("\nTest Case 2:");
        System.out.println(reverseEachWord("java is fun"));

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a sentence to reverse (or press Enter to skip): ");
        String customSentence = sc.nextLine();
        if (!customSentence.isEmpty()) {
            System.out.println(reverseEachWord(customSentence));
        }
        sc.close();
    }
}
