import java.util.Scanner;


public class Problem4_NumberPyramidPatternPrinter {

    static void printNumberPyramid(int n) {
        for (int row = 1; row <= n; row++) {
            StringBuilder line = new StringBuilder();

            for (int col = 1; col <= row; col++) {
                line.append(row);
                if (col < row) {
                    line.append(" ");
                }
            }

            System.out.println(line);
        }
    }

    public static void main(String[] args) {
       
        System.out.println("Test Case 1:");
        printNumberPyramid(4);

        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number of rows for the pyramid (or 0 to skip): ");
        int customRows = sc.hasNextInt() ? sc.nextInt() : 0;
        if (customRows > 0) {
            printNumberPyramid(customRows);
        }
        sc.close();
    }
}
