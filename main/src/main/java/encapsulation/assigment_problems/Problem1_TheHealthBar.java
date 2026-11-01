package encapsulation.assigment_problems;

/**
 * Problem 1: The Health Bar
 *
 * A game Character whose health is private, clamped between 0 and a
 * final maximum, and only changed through takeDamage() and heal().
 */
public class Problem1_TheHealthBar {

    static class Character {
        private final int maxHealth;
        private int health;

        public Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = maxHealth; // Starts at full health
        }

        /** Reduces health by amount; never drops below 0 (extra damage is wasted). */
        public void takeDamage(int amount) {
            if (amount < 0) {
                System.out.println("Damage amount cannot be negative.");
                return;
            }
            int newHealth = health - amount;
            health = Math.max(0, newHealth);
        }

        /** Raises health by amount; never exceeds maxHealth (extra healing is wasted). */
        public void heal(int amount) {
            if (amount < 0) {
                System.out.println("Heal amount cannot be negative.");
                return;
            }
            int newHealth = health + amount;
            health = Math.min(maxHealth, newHealth);
        }

        // Read-only access — deliberately no setHealth()
        public int getHealth() {
            return health;
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("takeDamage(30) -> health = " + c.getHealth()); // 70

        c.heal(50);
        System.out.println("heal(50) -> health = " + c.getHealth() + " (capped)"); // 100

        c.takeDamage(150);
        System.out.println("takeDamage(150) -> health = " + c.getHealth() + " (floored)"); // 0
    }
}
