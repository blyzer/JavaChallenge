package com.jobsity.BowlingChallenge;

import java.util.List;

/**
 * The ScoreCalculator interface defines the contract for calculating the score
 * of a bowling game based on a list of rolls.
 */
interface ScoreCalculator {

    /**
     * Calculates the score for a given list of rolls in a bowling game.
     *
     * @param rolls The list of rolls representing the pins knocked down in each roll.
     * @return The calculated score for the game.
     */
    List<Integer> calculateScoreRoll(List<Integer> rolls);
    String formatRolls(List<Integer> rolls);
}
