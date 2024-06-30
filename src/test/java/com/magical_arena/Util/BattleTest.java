package com.magical_arena.Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BattleTest {
    @Test
    void TestPerformTurnWhenAttackReducesTheHealth(){
        Player p1 = Player.builder().health(90).strength(10).attack(20).build();
        Player p2 = Player.builder().health(100).strength(12).attack(10).build();
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(6)).thenReturn(2,3);
        Battle battle = new Battle(p1,p2,mockRandom);
        battle.performTurn();
        /*
         * Attack value = 60
         * Defense value = 48
         * difference = 12
         * p2 health now = 88
         */
        Assertions.assertEquals(88, p2.getHealth());
    }
    @Test
    void TestPerformTurnWhenAttackDoesNotReducesTheHealth(){

        Player p1 = Player.builder().health(90).strength(10).attack(20).build();
        Player p2 = Player.builder().health(100).strength(20).attack(10).build();
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(6)).thenReturn(2,3);
        Battle battle = new Battle(p1,p2,mockRandom);
        battle.performTurn();
        /*
         * Attack value = 60
         * Defense value = 80
         * difference = max(60-80,0) = 0
         * p2 health now = 100
         */
        Assertions.assertEquals(100, p2.getHealth());
    }
    @Test
    void TestACompleteBattle(){
        Player p1 = Player.builder().name("p1").health(10).strength(5).attack(3).build();
        Player p2 = Player.builder().name("p2").health(20).strength(4).attack(4).build();
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(6)).thenReturn(5,3, 5, 1);
        Battle battle = new Battle(p1,p2,mockRandom);
        /*
         * Round 1
         * -------------------
         * Attack value = 18
         * Defense value = 16
         * p2 health now = 18
         * ------------------
         * Round 2
         * -------------------
         * Attack value = 24
         * Defense value = 10
         * p2 health now = 0
         */
        Assertions.assertEquals("p2", battle.runMatch());
    }
}
