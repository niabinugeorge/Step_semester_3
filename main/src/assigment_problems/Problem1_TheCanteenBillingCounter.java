package assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem1_TheCanteenBillingCounter {

    abstract static class Customer {
        protected final double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract String label();

        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double amount) { super(amount); }

        @Override String label() { return "STUDENT"; }

        @Override double finalAmount() { return amount * 0.90; } // 10% discount
    }

    static class Staff extends Customer {
        Staff(double amount) { super(amount); }

        @Override String label() { return "STAFF"; }

        @Override double finalAmount() { return amount * 0.95; } // 5% discount
    }

    static class Guest extends Customer {
        Guest(double amount) { super(amount); }

        @Override String label() { return "GUEST"; }

        @Override double finalAmount() { return amount + 10; } // Rs 10 service charge
    }

    static Customer create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT": return new Student(amount);
            case "STAFF":   return new Staff(amount);
            case "GUEST":   return new Guest(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            bills.add(create(parts[0], Double.parseDouble(parts[1])));
        }

        double total = 0;
        for (Customer bill : bills) {
            double finalAmount = bill.finalAmount();
            System.out.println(String.format(Locale.US, "%s: %.2f", bill.label(), finalAmount));
            total += finalAmount;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
        sc.close();
    }
}
