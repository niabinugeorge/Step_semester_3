package arrays_strings.class_problems;

import java.util.Random;


public class Problem1_RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random RANDOM = new Random();


    static String generateComputerMove() {
        return MOVES[RANDOM.nextInt(MOVES.length)];
    }


    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int rounds = playerMoves.length;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String playerMove = playerMoves[i];
            String computerMove = generateComputerMove();
            String result = playRound(playerMove, computerMove);

            System.out.println((i + 1) + "     | " + playerMove + "\t\t| " + computerMove + "\t\t| " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\nFinal Summary (after " + rounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws +
                " | Win % = " + winPercentage + "%");
    }
}
