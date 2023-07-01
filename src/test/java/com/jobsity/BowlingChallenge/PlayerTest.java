package com.jobsity.BowlingChallenge;

import com.jobsity.BowlingChallenge.Frame;
import com.jobsity.BowlingChallenge.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The BowlingGameTest class is a unit test class for the BowlingGame class.
 * It tests the functionality of the testGetName method.
 * It tests the functionality of the testAddFrame method.
 * It tests the functionality of the testGetPinfalls method.
 * It tests the functionality of the testGetRolls method.
 */

public class PlayerTest {

    private Player player;
    /**
     * Sets up the test fixture before each test case.
     */
    @BeforeEach
    public void setup() {
        player = new Player("John");
    }

    /**
     * Tests the GetName method of the PlayerTest class.
     */
    @Test
    public void testGetName() {
        Assertions.assertEquals("John", player.getName());
    }

    /**
     * Tests the AddFrame method of the Player class.
     */
    @Test
    public void testAddFrame() {
        Frame frame1 = new Frame();
        Frame frame2 = new Frame();

        player.addFrame(frame1);
        player.addFrame(frame2);

        List<Frame> frames = player.getFrames();
        Assertions.assertEquals(2, frames.size());
        Assertions.assertTrue(frames.contains(frame1));
        Assertions.assertTrue(frames.contains(frame2));
    }

    /**
     * Tests the GetPinfalls method of the Player class.
     */
    @Test
    public void testGetPinfalls() {
        Frame frame1 = new Frame();
        frame1.addRoll(3);
        frame1.addRoll(5);

        Frame frame2 = new Frame();
        frame2.addRoll(10);

        player.addFrame(frame1);
        player.addFrame(frame2);

        List<Integer> pinfalls = player.getPinfalls();
        List<Integer> expectedPinfalls = Arrays.asList(3, 5, 10, 0);
        Assertions.assertEquals(expectedPinfalls, pinfalls);
    }

    /**
     * Tests the GetRolls method of the Player class.
     */
    @Test
    public void testGetRolls() {
        Frame frame1 = new Frame();
        frame1.addRoll(3);
        frame1.addRoll(5);

        Frame frame2 = new Frame();
        frame2.addRoll(10);

        player.addFrame(frame1);
        player.addFrame(frame2);

        List<Integer> rolls = player.getRolls();
        List<Integer> expectedRolls = Arrays.asList(3, 5, 10);
        Assertions.assertEquals(expectedRolls, rolls);
    }
}
