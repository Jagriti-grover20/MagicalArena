import java.util.Scanner;

import Util.Battle;
import Util.Player;
public class MagicalArena {

    public static void main(String[] args) {
        // Initialize players with dynamic input
        Player playerA = createPlayer("Player A");
        Player playerB = createPlayer("Player B");

        // Start a match in the magical arena
        Battle battle = new Battle(playerA, playerB);
        battle.start();

        // Determine and print the winner
        String outcome = determineOutcome(playerA, playerB);
        System.out.println("Winner of magical arena: " + outcome);
    }

    // Method to create a player with user-defined attributes
    private static Player createPlayer(String playerName) {
        System.out.println(playerName);
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter health attribute
        System.out.println("Enter the health of " + playerName + ":");
        int health = scanner.nextInt();

        // Prompt user to enter strength attribute
        System.out.println("Enter the strength of " + playerName + ":");
        int strength = scanner.nextInt();

        // Prompt user to enter attack attribute
        System.out.println("Enter the attack of " + playerName + ":");
        int attack = scanner.nextInt();

        return new Player(health, strength, attack);
    }

    // Method to determine the outcome of the match based on players' health
    private static String determineOutcome(Player playerA, Player playerB) {
        if (playerA.getHealth() <= 0 && playerB.getHealth() <= 0) {
            return "The match ends in a draw!";
        } else if (playerA.getHealth() <= 0) {
            return "Player B wins the match!";
        } else if (playerB.getHealth() <= 0) {
            return "Player A wins the match!";
        } else {
            return "The match is still ongoing.";
        }
    }
}
