package com.jobsity.BowlingChallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The BowlingGameTest class is a unit test class for the BowlingGame class.
 * It tests the functionality of the parseInput method.
 */
public class BowlingGameTest {

    private BowlingGame bowlingGame;

    /**
     * Sets up the test fixture before each test case.
     */
    @BeforeEach
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    /**
     * Tests the parseInput method of the BowlingGame class.
     */
    @Test
    public void testParseInput() {
        String input = """
                Jeff\t10
                John\t3
                John\t7
                Jeff\t7
                Jeff\t3
                John\t6
                John\t3
                Jeff\t9
                Jeff\t0
                John\t10
                Jeff\t10
                John\t8
                John\t1
                Jeff\t0
                Jeff\t8
                John\t10
                Jeff\t8
                Jeff\t2
                John\t10
                Jeff\tF
                Jeff\t6
                John\t9
                John\t0
                Jeff\t10
                John\t7
                John\t3
                Jeff\t10
                John\t4
                John\t4
                Jeff\t10
                Jeff\t8
                Jeff\t1
                John\t10
                John\t9
                John\t0""";

        bowlingGame.parseInput(input);

        List<Player> players = bowlingGame.getPlayers();
        Assertions.assertEquals(2, players.size());

        Player player1 = players.get(0);
        Assertions.assertEquals("Jeff", player1.getName());
        List<Frame> frames1 = player1.getFrames();
        Assertions.assertEquals(9, frames1.size());
        Assertions.assertEquals(2, frames1.get(0).getRolls().size());
        Assertions.assertEquals(1, frames1.get(8).getRolls().size());

        Player player2 = players.get(1);
        Assertions.assertEquals("John", player2.getName());
        List<Frame> frames2 = player2.getFrames();
        Assertions.assertEquals(9, frames2.size());
        Assertions.assertEquals(2, frames2.get(0).getRolls().size());
        Assertions.assertEquals(2, frames2.get(8).getRolls().size());
    }

    @Test
    public void testFormatPinfalls() {
        // Input list of pinfalls
        List<Integer> pinfalls = List.of(10, 0, 7, 3, 4, 6, 10, 0, 10, 0, 2, 8, 10, 0, 10, 0, 10, 10, 8, 1);

        // Format the pinfalls
        String formattedPinfalls = BowlingGame.formatPinfalls(pinfalls);

        // Verify the formatted pinfalls
        Assertions.assertEquals("X\t7\t/\t4\t6\tX\t0\tX\t0\t2\t/\tX\t0\tX\t0\tX\tX\t8\t1", formattedPinfalls);
    }

}
