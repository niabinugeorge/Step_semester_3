import java.util.Scanner;


public class Problem4_WarehouseInventoryBalancer {

   
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Sections must have the same number of items.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1; // 1-based item number

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + highestQuantity +
                " (" + highestSection + ", Item " + highestIndex + ")");
    }

    public static void main(String[] args) {
       
        System.out.println("Test Case 1:");
        int[] sectionA1 = {20, 15, 30};
        int[] sectionB1 = {25, 10, 30};
        analyzeInventory(sectionA1, sectionB1);

        
        System.out.println("\nTest Case 2:");
        int[] sectionA2 = {10, 20, 40};
        int[] sectionB2 = {5, 15, 25};
        analyzeInventory(sectionA2, sectionB2);

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number of items per section (or 0 to skip): ");
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        if (n > 0) {
            int[] customA = new int[n];
            int[] customB = new int[n];

            System.out.println("Enter " + n + " quantities for Section A:");
            for (int i = 0; i < n; i++) {
                customA[i] = sc.nextInt();
            }

            System.out.println("Enter " + n + " quantities for Section B:");
            for (int i = 0; i < n; i++) {
                customB[i] = sc.nextInt();
            }

            analyzeInventory(customA, customB);
        }
        sc.close();
    }
}
