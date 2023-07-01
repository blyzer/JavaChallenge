package com.jobsity.BowlingChallenge;

import com.jobsity.BowlingChallenge.BowlingGame;
import com.jobsity.BowlingChallenge.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The BowlingScoreCalculatorTest class is a unit test class for the BowlingScoreCalculator class.
 * It tests the functionality of the testFormatRolls method.
 * It tests the functionality of the testFormatRollsLong method.
 * It tests the functionality of the testCalculateScoreRollLong method.
 * It tests the functionality of the testCalculateScoreRoll method.
 */
public class BowlingScoreCalculatorTest {

    private ScoreCalculator scoreCalculator;

    /**
     * Sets up the test fixture before each test case.
     */
    @BeforeEach
    public void setup() {
        scoreCalculator = new BowlingScoreCalculator();
    }

    /**
     * Tests the FormatRolls method of the BowlingScoreCalculator class.
     */
    @org.junit.Test
    @Test
    public void testFormatRolls() {
        // Create a list of rolls
        List<Integer> rolls = List.of(4, 5, 6, 3, 10, 0, 7, 2);

        // Format the rolls as a string
        String formattedRolls = scoreCalculator.formatRolls(rolls);

        // Verify the formatted rolls string
        Assertions.assertEquals("4\t\t5\t\t6\t\t3\t\t10\t\t0\t\t7\t\t2", formattedRolls);
    }

    /**
     * Tests the FormatRolls method of the BowlingScoreCalculator class.
     */
    @Test
    public void testFormatRollsLong() {
        // Prepare the rolls for a game
        List<Integer> rolls = Arrays.asList(10, 0, 7, 3, 5, 5, 3, 2, 10, 0, 4, 6, 10, 0, 10, 0, 10, 7, 3, 10, 0, 10);

        // Format the rolls as a string
        String formattedRolls = scoreCalculator.formatRolls(rolls);

        // Verify the expected formatted rolls
        String expectedFormattedRolls = "10\t\t7\t\t3\t\t5\t\t5\t\t3\t\t2\t\t10\t\t4\t\t6\t\t10\t\t10\t\t10\t\t7\t\t3\t\t10\t\t10";
        Assertions.assertEquals(expectedFormattedRolls, formattedRolls);
    }

    /**
     * Tests the CalculateScoreRoll method of the BowlingScoreCalculator class.
     */
    @Test
    public void testCalculateScoreRollLong() {
        // Prepare the rolls for a game
        List<Integer> rolls = Arrays.asList(10, 0, 7, 3, 5, 5, 3, 2, 10, 0, 4, 6, 10, 0, 10, 0, 10, 7, 3, 10, 0, 10);

        // Calculate the scores for each frame
        List<Integer> scores = scoreCalculator.calculateScoreRoll(rolls);

        // Verify the expected scores
        List<Integer> expectedScores = Arrays.asList(20, 35, 43, 51, 71, 85, 105, 123, 143, 173);
        Assertions.assertEquals(expectedScores, scores);
    }

    /**
     * Tests the CalculateScoreRoll method of the BowlingScoreCalculator class.
     */
    @Test
    public void testCalculateScoreRoll() {
        // Create a list of rolls
        List<Integer> rolls = List.of(10, 7, 3, 4, 5, 2, 8, 9, 1, 10, 10, 10, 8, 1, 10, 9, 0);

        // Call the calculateScoreRoll method
        List<Integer> scores = scoreCalculator.calculateScoreRoll(rolls);

        // Verify the calculated scores
        List<Integer> expectedScores = List.of(20, 34, 43, 53, 82, 112, 131, 151, 161, 181);
        Assertions.assertEquals(expectedScores, scores);
    }

}
