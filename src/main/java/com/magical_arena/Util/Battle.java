package com.magical_arena.Util;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Battle {
    private Player attacker;
    private Player defender;
    private Dice dice;
    private Random randomUtility;

    // Constructor to initialize a battle between two players
    public Battle(Player player1, Player player2){
        this(player1, player2, new Random());
    }

    public Battle(Player player1, Player player2, Random random) {
        // Determine which player starts as attacker based on higher health
        if (player1.getHealth() < player2.getHealth()) {
            this.attacker = player1;
            this.defender = player2;
        } else {
            this.attacker = player2;
            this.defender = player1;
        }
        this.randomUtility = random;
        this.dice = new Dice(randomUtility);
    }

    // Method to start the battle between attacker and defender
    public String runMatch() {
        while (attacker.getHealth() > 0 && defender.getHealth() > 0) {
            performTurn();
            switchRoles();
        }
        if(defender.getHealth() <= 0) {
            return attacker.getName();
        }
        return defender.getName();
    }

    // Method to perform a turn in the battle
    public void performTurn() {
        int attackRoll = dice.rollDie();
        int defendRoll = dice.rollDie();
        // Calculate attacker's damage
        int attackDamage = attackRoll * attacker.getAttack();
        // Calculate defender's defense
        int defendDamage = defendRoll * defender.getStrength();
        // Calculate net damage to defender
        int netDamage = Math.max(0, attackDamage - defendDamage);
        // Reduce defender's health based on net damage
        defender.reduceHealth(netDamage);
    }

    // Method to switch roles between attacker and defender after each turn
    private void switchRoles() {
        Player temp = attacker;
        attacker = defender;
        defender = temp;
    }
}
