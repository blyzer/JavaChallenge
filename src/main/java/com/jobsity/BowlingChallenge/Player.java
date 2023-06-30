package com.jobsity.BowlingChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * The Player class represents a player in a bowling game.
 */
public class Player {
    private final String name;
    private final List<Frame> frames;
    /**
     * Constructs a new Player object with the given name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.frames = new ArrayList<>();
    }

    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a frame to the player's list of frames.
     *
     * @param frame The frame to be added.
     */
    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    /**
     * Returns a list of pinfalls for the player.
     * A pinfall represents the number of pins knocked down in each roll of all frames.
     *
     * @return A list of integers representing the pinfalls for the player.
     */
    public List<Integer> getPinfalls() {
        List<Integer> pinfalls = new ArrayList<>();
        for (Frame frame : frames) {
            pinfalls.addAll(frame.getPinfalls());
        }
        return pinfalls;
    }

    /**
     * Returns a list of rolls for the player.
     * A roll represents the number of pins knocked down in each roll of all frames.
     *
     * @return A list of integers representing the rolls for the player.
     */
    public List<Integer> getRolls() {
        List<Integer> rolls = new ArrayList<>();
        for (Frame frame : frames) {
            rolls.addAll(frame.getRolls());
        }
        return rolls;
    }

    /**
     * Returns a list of frames for the player.
     *
     * @return the list of frames
     */
    public List<Frame> getFrames() {
        return new ArrayList<>(frames);
    }


}
