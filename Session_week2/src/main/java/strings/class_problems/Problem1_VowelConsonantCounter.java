package strings.class_problems;

public class Problem1_VowelConsonantCounter {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (c == ' ') {
                continue;
            }

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {

        System.out.println("Test Case 1:");
        countVowelsAndConsonants("Java Programming");

        System.out.println("\nTest Case 2:");
        countVowelsAndConsonants("Coding Club");
    }
}
