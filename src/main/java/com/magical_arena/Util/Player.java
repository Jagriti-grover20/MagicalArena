package com.magical_arena.Util;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Player {
    private int health;
    private int strength;
    private int attack;
    private String name;

    // Method to reduce player's health based on damage taken
    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}
