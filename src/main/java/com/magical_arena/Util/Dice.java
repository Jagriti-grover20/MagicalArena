package com.magical_arena.Util;

import java.util.Random;

public class Dice {
    private Random random;

    // Constructor to initialize a dice roller
    public Dice(Random random) {
        this.random = random;
    }

    // Method to roll a standard 6-sided die and return the result
    public int rollDie() {
        return random.nextInt(6) + 1;
    }
}

