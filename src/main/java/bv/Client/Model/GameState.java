package bv.Client.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.stage.Stage;
import bv.Client.Client;
import bv.Client.MVC.GameSceneController;
import bv.Client.MVC.SceneController;
import bv.Client.utils.InitialGame;

/**
 * The GameState class is responsible for managing game states and data
 * between different classes.
 * 
 * It is contains all states, logic, and data of the application.
 */

public class GameState {

    public static Players Players = new Players();
    public static GameLogic gameLogic = new GameLogic();
    public static Client client;
    public static Stage stage;

    private static SceneController sc = SceneController.getInstance();

    public static boolean isOnline = false;
    public static String imageString;
    public static String answer;
    public static int countDownTimer;

    /**
     * Returns the card image as a string.
     * 
     * If the game is not online, the method prints "game is not online" and returns
     * the value of the static field `imageString`.
     * If the game is online, the method prints the result of calling
     * `gameLogic.getCardImage()` and returns the same value.
     * 
     * @return the card image as a string
     */
    public static String getCardImage() {
        if (GameState.isOnline) {
            System.out.println("game is not online");
            return imageString;
        }
        System.out.println(gameLogic.getCardImage());
        return gameLogic.getCardImage();
    }

    /**
     * 
     * Gets the list of values in the game, sorted in ascending order.
     * 
     * @return the list of values in the game, sorted in ascending order
     */
    public static ArrayList<String> getArrayValue() {
        ArrayList<String> result = Lids.convertToValue(gameLogic.myList);
        Collections.sort(result);
        return result;
    }

    /**
     * This method retrieves the answer of the current game. If the game is online,
     * it returns the answer, otherwise it returns the result of
     * {@link GameLogic#getAnswer()}
     * 
     * @return the answer of the current game
     */
    public static String getAnswer() {
        if (GameState.isOnline) {
            return answer;
        }
        return gameLogic.getAnswer();
    }

    /**
     * This method updates the current game. If the total number of discs is greater
     * than or equal to the number of dices, it removes the guess picture button and
     * updates the game, otherwise it loads the leaderboard scene.
     * 
     * @param stage the stage on which the game is currently being played
     * @throws IOException if the leaderboard scene could not be loaded
     */
    public static void updateGame(Stage stage) throws IOException {
        gameLogic.totalDisc--;
        if (gameLogic.totalDisc >= Dice.numDice) {
            GameSceneController bgc = GameSceneController.getInstance();
            gameLogic.pictureName.remove(GameState.getAnswer());
            bgc.removeGuessPictureBtn();
            bgc.update();
            return;
        } else {
            // create leaderboard here
            sc.loadSceneByStage(stage, "LeaderBoard");
        }
    }

    /**
     * 
     * This method updates the online game information when the game is ongoing.
     * It reduces the totalDisc by 1 and adds score to the player.
     * 
     * @return false if the totalDisc is not greater than 20, true otherwise.
     */
    public static boolean updateGameOnline() {
        gameLogic.totalDisc--;
        Players.addScore();
        if (gameLogic.totalDisc >= Dice.numDice) {
            return false;
        }
        return true;
    }

    /**
     * This method starts the game in online mode. It generates the discs
     * information
     * and shuffles them to create randomness in the game. It also sets the
     * pictureName
     * field with the sorted array of the discs information.
     */
    public static void startGame() {
        System.out.println("Initializing...");
        try {
            InitialGame.generateDisc(gameLogic.myList);
            Collections.shuffle(gameLogic.myList);
            gameLogic.pictureName = getArrayValue();
        } catch (Exception e) {
            System.out.println("Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}