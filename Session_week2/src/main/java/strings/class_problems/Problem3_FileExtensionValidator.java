package strings.class_problems;


public class Problem3_FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};


    static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        System.out.println(validateFileExtension("Assignment1.PDF"));

        System.out.println("Test Case 2:");
        System.out.println(validateFileExtension("notes.txt"));
    }
}
