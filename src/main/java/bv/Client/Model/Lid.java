package bv.Client.Model;

import java.util.ArrayList;

/**
 * Create dics on the board game
 * 
 * The Lids class represents a game Lids, with a value and a corresponding
 * image.
 * 
 * It has properties to check if the Lids has a cover, is selected as a guess,
 * and to get the image and value.
 */

public class Lid {
    /** The file name of the image of the Lids */
    private String cardImage;
    /** The name of the Lids */
    private String value;
    /** Indicates if the Lids has a cover */
    private boolean hasCover = false;
    /** Indicates if the Lids is selected as a guess */
    private boolean isGuess = false;

    /**
     * Gets the name of the Lids.
     *
     * @return the name of the Lids
     */
    public String getValue() {
        return value;
    };

    /**
     * Checks if the Lids has a cover.
     *
     * @return true if the Lids has a cover, false otherwise
     */
    public boolean checkCover() {
        return hasCover;
    }

    /**
     * Gets the image of the Lids.
     *
     * @return the image of the Lids
     */
    public String getImage() {
        return cardImage;
    }

    /**
     * Gets the file name of the image of the Lids.
     *
     * @return the file name of the image of the Lids
     */
    // The file name of image
    public String getCardImage() {
        return cardImage;
    }

    /**
     * Creates a new Lids with the given image and value.
     *
     * @param cardImage the file name of the image of the Lids
     * @param value     the name of the Lids
     */
    public Lid(String cardImage, String value) {
        this.cardImage = cardImage;
        this.value = value;
    }

    /**
     * Sets a cover for the Lids.
     */
    public void setCover() {
        hasCover = true;
    }

    /**
     * Sets the Lids as a guess.
     */
    public void setGuess() {
        isGuess = true;
    }

    /**
     * Checks if the Lids is a guess.
     *
     * @return true if the Lids is a guess, false otherwise
     */
    public boolean checkIsGuess() {
        return isGuess;
    }

    /**
     * Converts a list of Lids objects to a list of their values.
     *
     * @param LidArrayList a list of Lids objects
     * @return a list of the values of the Lids objects
     */
    public static ArrayList<String> convertToValue(ArrayList<Lid> LidArrayList) {
        ArrayList<String> result = new ArrayList<>();
        for (Lid Lid : LidArrayList) {
            if (!Lid.checkIsGuess()) {
                result.add(Lid.value);
            }
        }
        return result;
    }

}
