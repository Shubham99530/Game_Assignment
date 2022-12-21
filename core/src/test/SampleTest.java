package org.junit;

import com.game_assignment.game.PlayScreen;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Test;
//import org.junit.*;


public class SampleTest {
    @Test
    public void testY() {
        PlayScreen play = new PlayScreen(game, tankA, tankB);
        float sum1 = play.gety(120, 20, Math.toRadians(45));
        assertEquals(116.472, sum1);
    }
}
