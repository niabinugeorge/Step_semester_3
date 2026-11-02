package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3: Delivery Fee Calculator
 *
 * Each delivery type extends Delivery and implements its own fee().
 * The extra CustomsFee for international deliveries lives inside
 * InternationalDelivery, so the main flow treats every request the same.
 *
 * NOTE ON THE PDF: the business rules (as written) give
 *   STANDARD 10 50          -> 5 + 0.50*10 + 0.10*50          = 15.00
 *   EXPRESS 5 20            -> 15 + 1.00*5 + 0.20*20          = 24.00
 *   INTERNATIONAL 20 100 30 -> 25 + 2.00*20 + 0.50*100 + 30   = 145.00
 * but the PDF's sample output shows 15.00 / 29.00 / 155.00 (total 199.00).
 * Only the Standard line agrees. This code follows the written rules;
 * if the instructor confirms the sample is right, the fixed base fees
 * below are the values to change.
 *
 * Sample input:                 Output (per the written rules):
 *   3                             STANDARD: 15.00
 *   STANDARD 10 50                EXPRESS: 24.00
 *   EXPRESS 5 20                  INTERNATIONAL: 145.00
 *   INTERNATIONAL 20 100 30       Total: 184.00
 */
public class Problem3_DeliveryFeeCalculator {

    abstract static class Delivery {
        protected final double weight;
        protected final double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract String label();

        abstract double fee();
    }

    static class StandardDelivery extends Delivery {
        private static final double BASE_FEE = 5.0;

        StandardDelivery(double weight, double distance) { super(weight, distance); }

        @Override String label() { return "STANDARD"; }

        @Override double fee() { return BASE_FEE + 0.50 * weight + 0.10 * distance; }
    }

    static class ExpressDelivery extends Delivery {
        private static final double BASE_FEE = 15.0;

        ExpressDelivery(double weight, double distance) { super(weight, distance); }

        @Override String label() { return "EXPRESS"; }

        @Override double fee() { return BASE_FEE + 1.00 * weight + 0.20 * distance; }
    }

    static class InternationalDelivery extends Delivery {
        private static final double BASE_FEE = 25.0;
        private final double customsFee; // the extra value lives here, not in the main flow

        InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override String label() { return "INTERNATIONAL"; }

        @Override double fee() { return BASE_FEE + 2.00 * weight + 0.50 * distance + customsFee; }
    }

    /** Builds the right Delivery from one line's tokens: Type Weight Distance [CustomsFee]. */
    static Delivery create(String[] parts) {
        double weight = Double.parseDouble(parts[1]);
        double distance = Double.parseDouble(parts[2]);

        switch (parts[0].toUpperCase()) {
            case "STANDARD":      return new StandardDelivery(weight, distance);
            case "EXPRESS":       return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL": return new InternationalDelivery(weight, distance, Double.parseDouble(parts[3]));
            default: throw new IllegalArgumentException("Unknown delivery type: " + parts[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deliveries.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.fee();
            System.out.println(String.format(Locale.US, "%s: %.2f", delivery.label(), fee));
            total += fee;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
        sc.close();
    }
}
