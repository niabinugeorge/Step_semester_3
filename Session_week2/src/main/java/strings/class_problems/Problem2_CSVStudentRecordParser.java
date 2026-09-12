package strings.class_problems;


public class Problem2_CSVStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String rollNumber = fields[1];
        String department = fields[2];

        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        System.out.println("Test Case 2:");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
