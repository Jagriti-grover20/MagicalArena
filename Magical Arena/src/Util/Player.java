package Util;

public class Player {
    private int health;
    private int strength;
    private int attack;

    // Constructor to initialize player attributes
    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Method for retrieving player's health
    public int getHealth() {
        return health;
    }

    // Method for retrieving player's strength
    public int getStrength() {
        return strength;
    }

    // Method for retrieving player's attack
    public int getAttack() {
        return attack;
    }

    // Method to reduce player's health based on damage taken
    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}
