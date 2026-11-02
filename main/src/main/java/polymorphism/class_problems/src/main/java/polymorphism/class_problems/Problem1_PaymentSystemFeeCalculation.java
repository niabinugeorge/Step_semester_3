package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1: Payment System Fee Calculation
 *
 * Each payment method extends Payment and applies its own fee in
 * finalAmount(). The processor loops over Payment objects uniformly
 * and never checks which method each one is.
 *
 * Sample input:            Expected output:
 *   3                        CARD: 1020.00
 *   CARD 1000                WALLET: 505.00
 *   WALLET 500               BANKTRANSFER: 2000.00
 *   BANKTRANSFER 2000        Total: 3525.00
 */
public class Problem1_PaymentSystemFeeCalculation {

    abstract static class Payment {
        protected final double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract String label();

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }

        @Override String label() { return "CARD"; }

        @Override double finalAmount() { return amount + amount * 0.02; } // 2% fee
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }

        @Override String label() { return "WALLET"; }

        @Override double finalAmount() { return amount + amount * 0.01; } // 1% fee
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }

        @Override String label() { return "BANKTRANSFER"; }

        @Override double finalAmount() { return amount; } // no fee
    }

    /** The only place the type word is looked at — turning input text into an object. */
    static Payment create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":         return new CardPayment(amount);
            case "WALLET":       return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            payments.add(create(parts[0], Double.parseDouble(parts[1])));
        }

        // Uniform processing: no type checks here
        double total = 0;
        for (Payment payment : payments) {
            double adjusted = payment.finalAmount();
            System.out.println(String.format(Locale.US, "%s: %.2f", payment.label(), adjusted));
            total += adjusted;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
        sc.close();
    }
}
