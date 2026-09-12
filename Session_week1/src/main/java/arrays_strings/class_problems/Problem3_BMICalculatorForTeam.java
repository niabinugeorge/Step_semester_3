package arrays_strings.class_problems;

import java.util.Random;

public class Problem3_BMICalculatorForTeam {


    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person   | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-2d| %.2f       | %.1f        | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random random = new Random();

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.50;
            weights[i] = 45 + random.nextDouble() * 55;
        }

        printWellnessReport(heights, weights);

        System.out.println("\nSample check:");
        double sampleBmi1 = 70 / (1.75 * 1.75);
        System.out.printf("Person 1 — Height: 1.75 m, Weight: 70 kg -> BMI: %.2f | Status: %s%n",
                sampleBmi1, getBmiStatus(sampleBmi1));

        double sampleBmi2 = 90 / (1.60 * 1.60);
        System.out.printf("Person 2 — Height: 1.60 m, Weight: 90 kg -> BMI: %.2f | Status: %s%n",
                sampleBmi2, getBmiStatus(sampleBmi2));
    }
}
