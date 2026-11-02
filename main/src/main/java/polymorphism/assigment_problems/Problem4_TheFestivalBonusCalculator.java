package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4: The Festival Bonus Calculator
 *
 * Employee holds the details every type shares (name, salary). Each
 * subclass supplies its own bonus() rule, and the payroll loop never
 * checks the employee type.
 *
 * Sample input:            Expected output:
 *   3                        Asha: 5000.00
 *   FULLTIME Asha 50000      Ravi: 1500.00
 *   PARTTIME Ravi 30000      Neha: 2000.00
 *   INTERN Neha 15000        Total Bonus: 8500.00
 */
public class Problem4_TheFestivalBonusCalculator {

    abstract static class Employee {
        protected final String name;
        protected final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        String getName() {
            return name;
        }

        abstract double bonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) { super(name, salary); }

        @Override double bonus() { return monthlySalary * 0.10; } // 10% of salary
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) { super(name, salary); }

        @Override double bonus() { return monthlySalary * 0.05; } // 5% of salary
    }

    static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }

        @Override double bonus() { return 2000.0; } // fixed Rs 2,000, whatever the salary
    }

    static Employee create(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN":   return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            employees.add(create(parts[0], parts[1], Double.parseDouble(parts[2])));
        }

        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.bonus();
            System.out.println(String.format(Locale.US, "%s: %.2f", employee.getName(), bonus));
            total += bonus;
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", total));
        sc.close();
    }
}
