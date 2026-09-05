import java.util.Scanner;


public class Problem3_ProductInventoryCSVParser {

   
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
        
        System.out.println("Test Case 1:");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        
        System.out.println("Test Case 2:");
        parseInventoryRecord("Wireless Mouse,150");

     
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a CSV line (ProductName,SKU,Quantity) or press Enter to skip: ");
        String customLine = sc.nextLine();
        if (!customLine.isEmpty()) {
            parseInventoryRecord(customLine);
        }
        sc.close();
    }
}
