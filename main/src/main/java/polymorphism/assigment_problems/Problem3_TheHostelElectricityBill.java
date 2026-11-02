package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3: The Hostel Electricity Bill
 *
 * Every room type extends Room and implements bill(). The extra value
 * a shared room needs (occupants) lives inside SharedRoom itself, so
 * the main flow can still treat every Room identically.
 *
 * Sample input:        Expected output:
 *   3                    SINGLE: 960.00
 *   SINGLE 120           SHARED: 300.00
 *   SHARED 150 3         AC: 1200.00
 *   AC 100               Total: 2460.00
 */
public class Problem3_TheHostelElectricityBill {

    abstract static class Room {
        protected final int units;

        Room(int units) {
            this.units = units;
        }

        abstract String label();

        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }

        @Override String label() { return "SINGLE"; }

        @Override double bill() { return 8.0 * units; } // Rs 8 per unit
    }

    static class SharedRoom extends Room {
        private final int occupants; // the extra value lives here, not in the main flow

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override String label() { return "SHARED"; }

        @Override double bill() { return (6.0 * units) / occupants; } // Rs 6 per unit, split per occupant
    }

    static class ACRoom extends Room {
        ACRoom(int units) { super(units); }

        @Override String label() { return "AC"; }

        @Override double bill() { return 10.0 * units + 200.0; } // Rs 10 per unit + Rs 200 fixed
    }

    /** Builds the right Room from one input line's tokens (RoomType Units [Occupants]). */
    static Room create(String[] parts) {
        int units = Integer.parseInt(parts[1]);
        switch (parts[0].toUpperCase()) {
            case "SINGLE": return new SingleRoom(units);
            case "SHARED": return new SharedRoom(units, Integer.parseInt(parts[2]));
            case "AC":     return new ACRoom(units);
            default: throw new IllegalArgumentException("Unknown room type: " + parts[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Room room : rooms) {
            double bill = room.bill();
            System.out.println(String.format(Locale.US, "%s: %.2f", room.label(), bill));
            total += bill;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
        sc.close();
    }
}
