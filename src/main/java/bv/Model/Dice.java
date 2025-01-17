package bv.Model;

import java.util.Random;

public class Dice {
    private int numberOfFaces;
    private int result;
    private Random random;

    // Constructor
    public Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
        this.random = new Random();
        this.result = -1; // Initially no roll result
    }

    // Roll the dice to get a random face (0 to numberOfFaces - 1)
    public void roll() {
        this.result = random.nextInt(numberOfFaces); // Random number between 0 and (numberOfFaces - 1)
    }

    // Get the result of the last roll
    public int getResult() {
        if (result == -1) {
            throw new IllegalStateException("Dice has not been rolled yet.");
        }
        return result;
    }

    // For testing purposes
    public static void main(String[] args) {
        Dice dice = new Dice(6); // 6 faces (e.g., 5 lids + poker face)

        // Simulate rolling the dice a few times
        for (int i = 0; i < 10; i++) {
            dice.roll();
            System.out.println("Dice rolled: " + dice.getResult());
        }
    }
}

