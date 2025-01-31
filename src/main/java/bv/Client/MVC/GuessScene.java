package bv.Client.MVC;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import bv.Client.Model.GameState;

/**
 * This class manages what to do when a color appears.
 */
public class GuessScene {

    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    @FXML
    private Pane mypane;
    @FXML
    private Button nextButton;
    private List<String> colorList = Arrays.asList(GameState.gameLogic.imageArray());
    SoundController soundc = new SoundController();

    public void display() {
        choiceBox.getItems().addAll(colorList);
    }

    public void closePopUp() {
        soundc.click();
        SceneController sc = SceneController.getInstance();
        String myChoice = choiceBox.getValue();
        if (myChoice == null) {
            sc.showAlertMessage(Alert.AlertType.ERROR, "Missing input", "Please choose a value!!");
            return;
        }
        Stage popupwindow = (Stage) mypane.getScene().getWindow();
        popupwindow.close();
        if (GameState.isOnline) {
            GameState.client.chooseColor(myChoice);
            return;
        }
        GameState.gameLogic.COLOR = myChoice;
        GameSceneController bgc = GameSceneController.getInstance();
        bgc.getNormalColor();
    }
}
