package encapsulation.class_problems;

/**
 * Problem 1: The Piggy Bank
 *
 * Savings is private and can only change through deposit() and
 * withdraw(); over-withdrawals are rejected; the ID is final.
 */
public class Problem1_ThePiggyBank {

    static class PiggyBank {
        private final String id;
        private int savings;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0; // A new piggy bank starts at 0
        }

        public String getId() {
            return id;
        }

        public void deposit(int amount) {
            if (amount <= 0) {
                System.out.println("Deposit must be positive — rejected.");
                return;
            }
            savings += amount;
        }

        public void withdraw(int amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal must be positive — rejected.");
                return;
            }
            if (amount > savings) {
                System.out.println("Withdrawal of " + amount + " rejected — only " + savings + " saved.");
                return;
            }
            savings -= amount;
        }

        // Read-only access — deliberately no setSavings()
        public int getSavings() {
            return savings;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("deposit(100) -> savings = " + pb.getSavings()); // 100

        pb.withdraw(30);
        System.out.println("withdraw(30) -> savings = " + pb.getSavings()); // 70

        pb.withdraw(500); // rejected
        System.out.println("withdraw(500) -> savings stays " + pb.getSavings()); // 70
    }
}
