package encapsulation.assigment_problems;

/**
 * Problem 4: The Traffic Light
 *
 * A TrafficLight whose color can only advance through the fixed cycle
 * RED -> GREEN -> YELLOW -> RED via next(); there is no way to set it
 * to an arbitrary color.
 */
public class Problem4_TheTrafficLight {

    static class TrafficLight {
        private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

        private final String id;
        private int colorIndex; // private: next() is the only way to change it

        public TrafficLight(String id) {
            this.id = id;
            this.colorIndex = 0; // A new light starts on RED
        }

        public String getId() {
            return id;
        }

        public String getColor() {
            return CYCLE[colorIndex];
        }

        /** Advances to the next color in the cycle and returns it. */
        public String next() {
            colorIndex = (colorIndex + 1) % CYCLE.length;
            return CYCLE[colorIndex];
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("getColor() -> " + t.getColor()); // RED
        System.out.println("next() -> " + t.next());         // GREEN
        System.out.println("next() -> " + t.next());         // YELLOW
        System.out.println("next() -> " + t.next());         // RED
        System.out.println("next() -> " + t.next());         // GREEN (cycle continues)
    }
}
