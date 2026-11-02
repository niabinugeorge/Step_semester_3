package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5: Public Transport Fare Calculator
 *
 * Each transport type extends Transport and implements its own fare().
 * The Metro's PeakHourFactor lives inside Metro itself, so the main flow
 * treats every journey the same way.
 *
 * Sample input:      Expected output:
 *   3                  BUS: 3.50
 *   BUS 15             TRAIN: 10.50
 *   TRAIN 50           METRO: 5.25
 *   METRO 10 1.5       Total: 19.25
 */
public class Problem5_PublicTransportFareCalculator {

    abstract static class Transport {
        protected final double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract String label();

        abstract double fare();
    }

    static class Bus extends Transport {
        Bus(double distance) { super(distance); }

        @Override String label() { return "BUS"; }

        // Base $2 + $0.10/km, capped at $10
        @Override double fare() { return Math.min(10.0, 2.0 + 0.10 * distance); }
    }

    static class Train extends Transport {
        Train(double distance) { super(distance); }

        @Override String label() { return "TRAIN"; }

        // Base $3 + $0.15/km
        @Override double fare() { return 3.0 + 0.15 * distance; }
    }

    static class Metro extends Transport {
        private final double peakHourFactor; // the extra value lives here, not in the main flow

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override String label() { return "METRO"; }

        // (Base $1.50 + $0.20/km) x PeakHourFactor
        @Override double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    }

    /** Builds the right Transport from one line's tokens: Type Distance [PeakHourFactor]. */
    static Transport create(String[] parts) {
        double distance = Double.parseDouble(parts[1]);

        switch (parts[0].toUpperCase()) {
            case "BUS":   return new Bus(distance);
            case "TRAIN": return new Train(distance);
            case "METRO": return new Metro(distance, Double.parseDouble(parts[2]));
            default: throw new IllegalArgumentException("Unknown transport type: " + parts[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            journeys.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Transport journey : journeys) {
            double fare = journey.fare();
            System.out.println(String.format(Locale.US, "%s: %.2f", journey.label(), fare));
            total += fare;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
        sc.close();
    }
}
