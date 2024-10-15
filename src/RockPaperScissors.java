import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            String playerA = getValidMove(scanner, "Player A");
            String playerB = getValidMove(scanner, "Player B");

            String result = determineWinner(playerA, playerB);
            System.out.println(result);

            playAgain = promptPlayAgain(scanner);

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getValidMove(Scanner scanner, String player) {
        String move;
        while (true) {
            System.out.print(player + ", enter your move (R, P, S): ");
            move = scanner.nextLine().trim().toUpperCase();

            if (move.equals("R") || move.equals("P") || move.equals("S")) {
                return move;
            } else {
                System.out.println("Invalid move! Please enter R, P, or S.");
            }
        }
    }

    private static String determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            return "It's a Tie! Both players chose " + getMoveName(playerA) + ".";
        }

        switch (playerA + playerB) {
            case "RS":
                return "Rock breaks Scissors. Player A wins!";
            case "PR":
                return "Paper covers Rock. Player A wins!";
            case "SP":
                return "Scissors cuts Paper. Player A wins!";
            case "SR":
                return "Rock breaks Scissors. Player B wins!";
            case "RP":
                return "Paper covers Rock. Player B wins!";
            case "PS":
                return "Scissors cuts Paper. Player B wins!";
            default:
                return "Unexpected result.";
        }
    }

    private static String getMoveName(String move) {
        switch (move) {
            case "R":
                return "Rock";
            case "P":
                return "Paper";
            case "S":
                return "Scissors";
            default:
                return "";
        }
    }

    private static boolean promptPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to play again? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("Y")) {
                return true;
            } else if (choice.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input! Please enter Y or N.");
            }
        }
    }
}
