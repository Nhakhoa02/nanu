package bv.Server;

import bv.Client.Model.Pos;
import bv.Client.Model.Dice;
import bv.Client.Model.GameState;

/**
 * The Helper class provides two static methods to generate and update the cover
 * hash map in the GameState.gameLogic class.
 * The cover hash map stores the mapping between the dice color and its position
 * in the game board represented by an index.
 */

public class Helper {
    /**
     * Generates the cover hash map by mapping the color of each dice to its
     * corresponding position on the game board.
     *
     * @param coords an array of Pos objects representing the positions of
     *               each dice on the game board.
     */
    public static void generateCoverHashMap(Pos[] coords) {
        for (int i = 0; i < Dice.numDice; i++) {
            int index = Pos.convertToIndex(coords[i]);
            GameState.gameLogic.coverHashMap.put(GameState.gameLogic.colorImage[i], index);
        }
    }

    /**
     * Updates the cover hash map by removing the mapping between the given
     * Pos and the color of the dice that was previously
     * placed at that position.
     *
     * @param coord the Pos object representing the position of the dice
     *              whose mapping needs to be removed from the cover hash map.
     */

    public static void updateCoverHashMap(Pos coord) {
        int index = Pos.convertToIndex(coord);
        GameState.gameLogic.coverHashMap.remove(GameState.gameLogic.COLOR, index);
    }
}
