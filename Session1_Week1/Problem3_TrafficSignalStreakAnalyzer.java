import java.util.Scanner;

public class Problem3_TrafficSignalStreakAnalyzer {

    
    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);

            if (c == currentColor) {
                currentLength++;
            } else {
                currentColor = c;
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Longest Streak: 'G' repeated 3 times
        System.out.println("Test Case 1:");
        findLongestStreak("RRGGGYRR");

        // Sample Input 2 -> Longest Streak: 'R' repeated 4 times
        System.out.println("Test Case 2:");
        findLongestStreak("RRRRYYGG");

       
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a signal log (or press Enter to skip): ");
        String customLog = sc.nextLine();
        if (!customLog.isEmpty()) {
            findLongestStreak(customLog);
        }
        sc.close();
    }
}
