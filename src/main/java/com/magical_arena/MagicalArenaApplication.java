package com.magical_arena;


import com.magical_arena.Util.Battle;
import com.magical_arena.Util.Player;

import java.util.Scanner;

public class MagicalArenaApplication {

	public static void main(String[] args) {
		// Initialize players with dynamic input
		Player playerA = createPlayer("Player A");
		Player playerB = createPlayer("Player B");

		// Start a match in the magical arena
		Battle battle = new Battle(playerA, playerB);
		String outcome = battle.runMatch();

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

		return  Player.builder().name(playerName).health(health).strength(strength).attack(attack).build();
	}
}
