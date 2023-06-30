package com.jobsity.BowlingChallenge;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
* The JobSityChallenge class is the main entry point for the Jobsity Bowling Challenge program.
* It reads input from a file, parses the data, and calculates the scores for each player.
*/
public class JobSityChallenge {
    /**
     * The main method is the entry point of the program.
     *
     * @param args The command-line arguments.
     * @throws IllegalArgumentException If an invalid argument is provided.
     */
    public static void main(String @NotNull [] args) throws IllegalArgumentException {

        File file = new File("src/test/resources/positive/scores.txt");
        String filePath = file.getAbsolutePath();
        if (args.length != 0) {
            filePath = args[0];
        }
        String input;
        try {
            input = readFile(filePath);
        } catch (Exception e) {
            System.out.println("Failed to read the input file: " + e.getMessage());

            return;
        }

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.parseInput(input);

        List<Player> players = bowlingGame.getPlayers();

        for (Player player : players) {
            System.out.print("Frame: \t  ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + "\t");
                System.out.print("\t");
            }
            System.out.println();
            System.out.println("Player:\t  " + player.getName());
            System.out.println("Pinfalls: " + BowlingGame.formatPinfalls(player.getPinfalls()));
            System.out.println("Score:\t  " + bowlingGame.getScoreRoll(player));
            System.out.println();
        }
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath The path of the file to read.
     * @return The content of the file as a string.
     * @throws Exception If an error occurs while reading the file.
     */
    private static String readFile(String filePath) throws Exception {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes);
    }
}