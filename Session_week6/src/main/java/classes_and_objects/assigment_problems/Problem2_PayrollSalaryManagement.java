package classes_and_objects.assigment_problems;

public class Problem2_PayrollSalaryManagement {

    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double openingBasicSalary) {
            if (openingBasicSalary < 0) {
                System.out.println("Warning: Negative opening salary given, starting at 0 instead.");
                this.basicSalary = 0;
            } else {
                this.basicSalary = openingBasicSalary;
            }
            this.bonus = 0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus amount must be positive — credit rejected.");
                return;
            }
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax percent must be between 0 and 100 — deduction rejected.");
                return;
            }
            basicSalary -= basicSalary * (percent / 100);
            System.out.println("Tax deducted: " + formatPercent(percent) + "%");
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }

        private String formatPercent(double percent) {
            if (percent == Math.floor(percent)) {
                return String.valueOf((long) percent);
            }
            return String.valueOf(percent);
        }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
