package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 5: The Streaming Plan Renewal Reminder
 *
 * Each plan (Basic / Standard / Premium) implements renewalDate() with
 * its own validity period. LocalDate.plusDays() handles leap years and
 * year changes automatically.
 *
 * Sample input:                     Expected output:
 *   4                                 Asha: 2024-02-14
 *   BASIC Asha 2024-01-15             Ravi: 2024-05-01
 *   STANDARD Ravi 2024-02-01          Neha: 2025-03-10
 *   PREMIUM Neha 2024-03-10           Kiran: 2025-01-19
 *   BASIC Kiran 2024-12-20
 */
public class Problem5_TheStreamingPlanRenewalReminder {

    interface Plan {
        LocalDate renewalDate(LocalDate startDate);
    }

    static class BasicPlan implements Plan {
        @Override public LocalDate renewalDate(LocalDate startDate) { return startDate.plusDays(30); }
    }

    static class StandardPlan implements Plan {
        @Override public LocalDate renewalDate(LocalDate startDate) { return startDate.plusDays(90); }
    }

    static class PremiumPlan implements Plan {
        @Override public LocalDate renewalDate(LocalDate startDate) { return startDate.plusDays(365); }
    }

    static class Subscriber {
        private final String name;
        private final Plan plan;
        private final LocalDate startDate;

        Subscriber(String name, Plan plan, LocalDate startDate) {
            this.name = name;
            this.plan = plan;
            this.startDate = startDate;
        }

        String getName() {
            return name;
        }

        LocalDate getRenewalDate() {
            return plan.renewalDate(startDate); // polymorphic call
        }
    }

    static Plan createPlan(String type) {
        switch (type.toUpperCase()) {
            case "BASIC":    return new BasicPlan();
            case "STANDARD": return new StandardPlan();
            case "PREMIUM":  return new PremiumPlan();
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            subscribers.add(new Subscriber(parts[1], createPlan(parts[0]), LocalDate.parse(parts[2])));
        }

        for (Subscriber subscriber : subscribers) {
            // LocalDate.toString() is already YYYY-MM-DD
            System.out.println(subscriber.getName() + ": " + subscriber.getRenewalDate());
        }
        sc.close();
    }
}
