package com.magical_arena.Util;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceTest {
    @Test
    public void rollDieAlwaysYieldBetween1And6(){
        Dice dice = new Dice(new Random());
        int dice_result = dice.rollDie();
        assertTrue(1 <= dice_result && dice_result <= 6);
    }
}
