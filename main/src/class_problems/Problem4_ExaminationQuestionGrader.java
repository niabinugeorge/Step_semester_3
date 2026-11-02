package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4: Examination Question Grader
 *
 * Each question type extends Question and implements its own grade().
 * The grader loops over Question objects and never checks the type.
 * Input fields are separated by spaces, with text fields in double quotes.
 *
 * Sample input:
 *   4
 *   MCQ "What is the capital of France?" "Paris" "Paris" 10
 *   TF "The Earth is flat?" "False" "True" 5
 *   ESSAY "Name two primary OOP principles." "Inheritance, Polymorphism, Encapsulation" "Polymorphism is one." 20
 *   ESSAY "Describe abstraction and composition." "Abstraction, Composition" "I talked about abstraction." 15
 *
 * Expected output:
 *   MCQ: 10.00
 *   TF: 0.00
 *   ESSAY: 10.00
 *   ESSAY: 7.50
 *   Total Score: 27.50
 */
public class Problem4_ExaminationQuestionGrader {

    abstract static class Question {
        protected final String text;
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final int points;

        Question(String text, String correctAnswer, String studentAnswer, int points) {
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract String label();

        abstract double grade();
    }

    static class MultipleChoiceQuestion extends Question {
        MultipleChoiceQuestion(String text, String correct, String student, int points) {
            super(text, correct, student, points);
        }

        @Override String label() { return "MCQ"; }

        @Override double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0; // exact match only
        }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String text, String correct, String student, int points) {
            super(text, correct, student, points);
        }

        @Override String label() { return "TF"; }

        @Override double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0; // exact match only
        }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String text, String correct, String student, int points) {
            super(text, correct, student, points);
        }

        @Override String label() { return "ESSAY"; }

        /** Counts keywords found in the answer (case-insensitive): 2+ -> 75%, 1 -> 50%, 0 -> 0. */
        @Override double grade() {
            String answer = studentAnswer.toLowerCase();
            int matched = 0;

            for (String keyword : correctAnswer.split(",")) {
                String k = keyword.trim().toLowerCase();
                if (!k.isEmpty() && answer.contains(k)) {
                    matched++;
                }
            }

            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    static Question create(String type, String text, String correct, String student, int points) {
        switch (type.toUpperCase()) {
            case "MCQ":   return new MultipleChoiceQuestion(text, correct, student, points);
            case "TF":    return new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY": return new EssayQuestion(text, correct, student, points);
            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    /** Splits a line into tokens, keeping text inside double quotes together (quotes removed). */
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        boolean hasToken = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
                hasToken = true;
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (hasToken) {
                    tokens.add(current.toString());
                    current.setLength(0);
                    hasToken = false;
                }
            } else {
                current.append(c);
                hasToken = true;
            }
        }
        if (hasToken) {
            tokens.add(current.toString());
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> t = tokenize(sc.nextLine().trim());
            // Type, QuestionText, CorrectAnswer, StudentAnswer, Points
            questions.add(create(t.get(0), t.get(1), t.get(2), t.get(3), Integer.parseInt(t.get(4))));
        }

        double total = 0;
        for (Question question : questions) {
            double score = question.grade();
            System.out.println(String.format(Locale.US, "%s: %.2f", question.label(), score));
            total += score;
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
        sc.close();
    }
}
