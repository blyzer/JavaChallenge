package com.jobsity.BowlingChallenge;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The BowlingScoreCalculator class implements the ScoreCalculator interface
 * and provides methods to calculate the score for a bowling game.
 */
public class BowlingScoreCalculator implements ScoreCalculator {

    /**
     * Calculates the score for a given list of rolls in a bowling game.
     *
     * @param rolls The list of rolls representing the pins knocked down in each roll.
     * @return The calculated score for the game.
     */
    @Override
    public List<Integer> calculateScoreRoll(List<Integer> rolls) {
        List<Integer> scores = new ArrayList<>();
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrikeRolls(rolls, rollIndex)) {
                score += 10 + strikeBonusRolls(rolls, rollIndex);
                scores.add(score);
                rollIndex++;
            } else if (isSpareRolls(rolls, rollIndex)) {
                score += 10 + spareBonusRolls(rolls, rollIndex);
                scores.add(score);
                rollIndex += 2;
            } else {
                score += rolls.get(rollIndex) + rolls.get(rollIndex + 1);
                scores.add(score);
                rollIndex += 2;
            }
        }
        return scores;
    }

    /**
     * Formats the roll into a list of every \ strings for each frame.
     * Strikes are represented as 'X', spares as '/', and other scores as their integer values.
     * Each frame's pinfalls are represented as a list of strings.
     *
     * @param rolls the list of frames for a rolls
     * @return a list of score strings for each roll
     */
    public String formatRolls(@NotNull List<Integer> rolls) {

        return rolls.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\t\t"));
    }

    /**

     Parses a string of scores into a list of integers representing the pinfalls.
     @param scoreString The string containing the scores.
     @return A list of integers representing the pinfalls.
     */
    public static @NotNull List<Integer> parseScores(@NotNull String scoreString) {
        List<Integer> scores = new ArrayList<>();
        String[] scoreParts = scoreString.split("\\s+");
        for (String score : scoreParts) {
            if (score.equalsIgnoreCase("F")) {
                scores.add(0);
            } else {
                try {
                    int pinsKnockedDown = Integer.parseInt(score);
                    if (pinsKnockedDown < 0 || pinsKnockedDown > 10) {
                        System.out.println("Invalid input: Score value should be between 0 and 10.");
                        System.exit(1);
                    }
                    scores.add(pinsKnockedDown);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: Score value should be an integer or 'F'.");
                    System.exit(1);
                }
            }
        }
        return scores;
    }

    /**
     * Checks if a roll is a strike.
     *
     * @param rolls      The list of rolls.
     * @param rollIndex The index of the roll.
     * @return true if the frame is a strike, false otherwise.
     */
    @Contract(pure = true)
    private boolean isStrikeRolls(@NotNull List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex) == 10;
    }

    /**
     * Checks if a roll is a spare.
     *
     * @param rolls      The list of rolls.
     * @param rollIndex The index of the roll.
     * @return true if the roll is a spare, false otherwise.
     */
    private boolean isSpareRolls(@NotNull List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10;
    }

    /**
     * Calculates the bonus points for a strike roll.
     *
     * @param rolls      The list of rolls.
     * @param rollIndex The index of the roll.
     * @return The bonus points for the strike roll.
     */
    private int strikeBonusRolls(@NotNull List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
    }

    /**
     * Calculates the bonus points for a spare roll.
     *
     * @param rolls      The list of rolls.
     * @param rollIndex The index of the roll.
     * @return The bonus points for the spare roll.
     */
    @Contract(pure = true)
    private int spareBonusRolls(@NotNull List<Integer> rolls, int rollIndex) {
        return rolls.get(rollIndex + 2);
    }
}
