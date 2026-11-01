package encapsulation.class_problems;

/**
 * Problem 3: The Nickname Tag
 *
 * An immutable NameTag: splits the full name once in the constructor,
 * stores final parts, and builds the nickname (first name + last
 * initial) from them.
 */
public class Problem3_TheNicknameTag {

    static final class NameTag {
        private final String firstName;
        private final String lastName;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" "); // split once, here only
            this.firstName = parts[0];
            this.lastName = parts[1];
        }

        public String getNickname() {
            return firstName + " " + lastName.charAt(0) + ".";
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("getNickname() -> \"" + tag.getNickname() + "\""); // "Maria G."

        // Two tags from the same name behave identically but are separate objects
        NameTag tag2 = new NameTag("Maria Gomez");
        System.out.println("tag2 nickname -> \"" + tag2.getNickname() + "\"");
        System.out.println("tag == tag2 -> " + (tag == tag2)); // false
    }
}
