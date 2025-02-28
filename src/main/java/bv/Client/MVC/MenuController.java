package bv.Client.MVC;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import bv.Client.Model.Dice;
import bv.Client.Model.GameState;

/**
 * The MenuController class provides functionality for the menu screen in a
 * game.
 *
 * It has sliders to adjust sound volume, combo boxes to select game difficulty
 * and theme, and buttons to navigate to different parts of the game.
 */
public class MenuController {
    @FXML
    Slider soundValue;
    @FXML
    Button HomeButton;
    @FXML
    ComboBox<String> theme = new ComboBox<>();
    @FXML
    ComboBox<Integer> difficulty = new ComboBox<>();
    @FXML
    ImageView dice;
    SoundController soundc = new SoundController();
    SceneController sc = SceneController.getInstance();

    @FXML
    public void initialize() throws FileNotFoundException {
        Integer number[] = { 1, 2, 3, 4, 5 };
        difficulty.getItems().addAll(number);
        soundValue.setValue(SoundController.volume * 100);
        displayThemes();
        theme.setPromptText(GameState.gameLogic.theme);
        difficulty.setPromptText(Dice.numDice + "");
    }

    public void returnHome(ActionEvent event) throws IOException {
        soundc.click();
        sc.homeScreen(event);
    }

    @FXML
    public void updateVolume() {
        Double sound = soundValue.getValue();
        SoundController.volume = sound / 100;
    }

    public void displayThemes() {

        // Creates an array in which we will store the names of files and directories
        String[] themes = { "default", "sport", "animal" };
        // File directory = new File("target/classes/bv/assets/Theme");
        // pathnames = directory.list();

        theme.getItems().addAll(themes);
    }

    @FXML
    public void setDifficulty() {
        Integer myChoice = difficulty.getValue();
        Dice.numDice = myChoice;
    }

    @FXML
    public void setTheme() {
        String myTheme = theme.getValue();
        GameState.gameLogic.theme = myTheme;
    }

}
