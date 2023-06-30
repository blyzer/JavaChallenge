package com.jobsity.BowlingChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * The Frame class represents a frame in a bowling game.
 */
public class Frame {
    private final List<Integer> rolls;

    /**
     * Constructs a new Frame object.
     * Initializes the list of rolls for the frame.
     */
    public Frame() {
        this.rolls = new ArrayList<>();
    }

    /**
     * Adds a roll to the frame, representing the number of pins knocked down.
     *
     * @param pinsKnockedDown The number of pins knocked down in the roll.
     */
    public void addRoll(int pinsKnockedDown) {
        rolls.add(pinsKnockedDown);
    }

    /**
     * Returns a new list containing the rolls of the frame.
     *
     * @return A new list of integers representing the rolls in the frame.
     */
    public List<Integer> getRolls() {
        return new ArrayList<>(rolls);
    }

    /**
     * Returns a list of pinfalls for the frame.
     * A pinfall represents the number of pins knocked down in each roll,
     * accounting for strikes as 10 followed by 0.
     *
     * @return A list of integers representing the pinfalls in the frame.
     */
    public List<Integer> getPinfalls() {
        List<Integer> pinfalls = new ArrayList<>();
        for (Integer roll : rolls) {
            if (roll == 10) {
                pinfalls.add(10);
                pinfalls.add(0);
            } else {
                pinfalls.add(roll);
            }
        }
        return pinfalls;
    }
}
