package classes_and_objects.assigment_problems;

public class Problem5_EmployeeAndCompanyInformationManagement {

    static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        // Static method — must not reference any instance field
        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {

        new Employee("Anita", 45000);
        new Employee("Rohan", 52000);
        new Employee("Meera", 48000);


        Employee.printCompanyInfo();
    }
}
