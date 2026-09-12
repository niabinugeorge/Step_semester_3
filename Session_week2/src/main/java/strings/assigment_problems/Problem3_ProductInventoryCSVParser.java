package strings.assigment_problems;

import java.util.Scanner;

/**
 * Problem 3: Product Inventory CSV Parser
 *
 * Parses a CSV line of the form "ProductName,SKU,Quantity" and prints
 * a formatted record, or reports an invalid record.
 */
public class Problem3_ProductInventoryCSVParser {

    /**
     * Parses a single CSV inventory line and prints a formatted record.
     * If the line does not contain exactly 3 fields, prints "Invalid Record".
     *
     * @param csvLine a line in the form "ProductName,SKU,Quantity"
     */
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0];
        String sku = fields[1];
        String quantity = fields[2];

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        // Sample Input 1 -> Product: Wireless Mouse | SKU: WM-2201 | Qty: 150
        System.out.println("Test Case 1:");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        // Sample Input 2 -> Invalid Record
        System.out.println("Test Case 2:");
        parseInventoryRecord("Wireless Mouse,150");

        // Optional: custom input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a CSV line (ProductName,SKU,Quantity) or press Enter to skip: ");
        String customLine = sc.nextLine();
        if (!customLine.isEmpty()) {
            parseInventoryRecord(customLine);
        }
        sc.close();
    }
}
