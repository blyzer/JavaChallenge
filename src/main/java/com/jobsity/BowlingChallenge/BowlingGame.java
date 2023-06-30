package com.jobsity.BowlingChallenge;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * The BowlingGame class represents a bowling game and provides methods for adding players,
 * parsing input data, calculating scores, and retrieving player information.
 */
public class BowlingGame {
    private final List<Player> players;
    private final ScoreCalculator scoreCalculator;
    private static final int ROLLING_FIRST_BALL = 0;
    private static final int ROLLING_SECOND_BALL = 1;
    private static int state = -1;

    /**
     * Constructs a new instance of the BowlingGame class.
     * Initializes the players list and the score calculator.
     */
    public BowlingGame() {
        this.players = new ArrayList<>();
        this.scoreCalculator = new BowlingScoreCalculator();
    }

    /**
     * Parses the input string and populates the game's data accordingly.
     *
     * @param input The input string to be parsed.
     */
    public void parseInput(String input) {
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String strScanned = scanner.nextLine();
                String[] parts = strScanned.split("\\s+");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int pinsKnockedDown = parsePinsKnockedDown(parts[1]);
                    addRollToPlayer(playerName, pinsKnockedDown);
                }
            }
        }
    }

    /**
     * Parses the string representation of pins knocked down in a roll.
     *
     * @param roll The string representation of pins knocked down.
     * @return The number of pins knocked down.
     */
    private int parsePinsKnockedDown(String roll) {
        if ("F".equals(roll)) {
            return 0;
        }
        return Integer.parseInt(roll);
    }

    /**
     * Adds a roll to the specified player.
     *
     * @param playerName       The name of the player.
     * @param pinsKnockedDown  The number of pins knocked down in the roll.
     */
    private void addRollToPlayer(String playerName, int pinsKnockedDown) {
        Player player = getPlayer(playerName);
        if (player == null) {
            player = new Player(playerName);
            players.add(player);
        }
        Frame frame = getCurrentFrame(player);
        if (frame == null || frame.getRolls().size() == 2) {
            frame = new Frame();
            player.addFrame(frame);
        }
        frame.addRoll(pinsKnockedDown);
    }

    /**
     * Retrieves the player object based on the player name.
     *
     * @param playerName The name of the player.
     * @return The Player object if found, or null if not found.
     */
    private @Nullable Player getPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Retrieves the list of players in the game.
     *
     * @return The list of players.
     */
    List<Player> getPlayers() {
        return players;
    }

    /**
     * Retrieves the current frame of the player.
     *
     * @param player The player object.
     * @return The current frame if available, or null otherwise.
     */
    private @Nullable Frame getCurrentFrame(Player player) {
        List<Frame> frames = player.getFrames();
        if (frames.isEmpty()) {
            return null;
        }
        Frame lastFrame = frames.get(frames.size() - 1);
        if (lastFrame.getRolls().size() < 2) {
            return lastFrame;
        }
        return null;
    }

    /**
     * Retrieves the score for the specified player.
     *
     * @param player The player for which to calculate the score by roll.
     * @return The score of the player.
     * @throws NullPointerException If the player object is null.
     */
    public String getScoreRoll(@NotNull Player player) {
        List<Integer> rolls = scoreCalculator.calculateScoreRoll(player.getRolls());
        return scoreCalculator.formatRolls(rolls);
    }

    /**
     * Formats the pinfalls for a given list of scores.
     *
     * @param pinfalls The list of pinfalls to format.
     * @return The formatted pinfalls string.
     */
    public static String formatPinfalls(@NotNull List<Integer> pinfalls) {
        AtomicReference<Integer> previousScore;
        previousScore = new AtomicReference<>(0);
        return pinfalls.stream()
                .map(score -> {
                    if (score == 10) {
                        previousScore.set(score);
                        if(state == -1)
                        {
                            state = ROLLING_SECOND_BALL;
                            return "X";
                        }
                        else {
                            return "X";
                        }
                    }  else if (score == 0 && state == ROLLING_SECOND_BALL && previousScore.get() != 10) {
                        state = ROLLING_FIRST_BALL;
                        previousScore.set(score);
                        return "/";
                    }  else if (score == 0 && previousScore.get() == 10) {
                        state = (state == ROLLING_FIRST_BALL) ? ROLLING_SECOND_BALL : ROLLING_FIRST_BALL;
                        previousScore.set(score);
                        return "";
                    } else {
                        previousScore.set(score);
                        return score.toString();
                    }
                })
                .collect(Collectors.joining("\t"));
    }

}