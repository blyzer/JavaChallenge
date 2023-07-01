package com.jobsity.BowlingChallenge;

import com.jobsity.BowlingChallenge.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The FrameTest class is a unit test class for the Frame class.
 * It tests the functionality of the testAddRoll method.
 * It tests the functionality of the testGetPinfalls method.
 */
public class FrameTest {

    private Frame frame;

    /**
     * Sets up the test fixture before each test case.
     */
    @BeforeEach
    public void setup() {
        frame = new Frame();
    }

    /**
     * Tests the AddRoll method of the Frame class.
     */
    @Test
    public void testAddRoll() {
        // Add rolls to the frame
        frame.addRoll(4);
        frame.addRoll(6);

        // Verify the rolls in the frame
        List<Integer> rolls = frame.getRolls();
        List<Integer> expectedRolls = Arrays.asList(4, 6);
        Assertions.assertEquals(expectedRolls, rolls);
    }

    /**
     * Tests the GetPinfalls method of the Frame class.
     */
    @Test
    public void testGetPinfalls() {
        // Add rolls to the frame
        frame.addRoll(10);
        frame.addRoll(0);

        // Get the pinfalls for the frame
        List<Integer> pinfalls = frame.getPinfalls();

        // Verify the expected pinfalls
        List<Integer> expectedPinfalls = Arrays.asList(10, 0);
        Assertions.assertEquals(expectedPinfalls, pinfalls);
    }
}
