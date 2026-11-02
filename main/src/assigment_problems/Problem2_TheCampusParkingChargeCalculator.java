package assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2: The Campus Parking Charge Calculator
 *
 * Bike, Car and Truck each extend Vehicle and implement their own
 * charge(). The parking system loops over Vehicle objects without
 * checking which kind each one is.
 *
 * Sample input:      Expected output:
 *   4                  BIKE: 30.00
 *   BIKE 3             CAR: 90.00
 *   CAR 4              TRUCK: 100.00
 *   TRUCK 1            CAR: 30.00
 *   CAR 1              Total: 250.00
 */
public class Problem2_TheCampusParkingChargeCalculator {

    abstract static class Vehicle {
        protected final int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract String label();

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }

        @Override String label() { return "BIKE"; }

        @Override double charge() { return 10.0 * hours; } // Rs 10 per hour
    }

    static class Car extends Vehicle {
        Car(int hours) { super(hours); }

        @Override String label() { return "CAR"; }

        @Override double charge() { return 30.0 + 20.0 * (hours - 1); } // Rs 30 first hour + Rs 20 each extra
    }

    static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }

        @Override String label() { return "TRUCK"; }

        @Override double charge() { return Math.max(100.0, 50.0 * hours); } // Rs 50/hour, minimum Rs 100
    }

    static Vehicle create(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":  return new Bike(hours);
            case "CAR":   return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            vehicles.add(create(parts[0], Integer.parseInt(parts[1])));
        }

        double total = 0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            System.out.println(String.format(Locale.US, "%s: %.2f", vehicle.label(), charge));
            total += charge;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
        sc.close();
    }
}
