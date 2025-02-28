package bv.Client.MVC;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import bv.Client.Model.GameState;

/**
 * This methods manages the window when the user inputs a wrong value.
 *
 * There will be given some methods like initialize() : shows what is behind the
 * cover
 * and closePopUp: what happens when the window will be closed and the next
 * players turn comes
 */

public class WrongSceneController {
    @FXML
    private Button nextBtn;
    @FXML
    private Text coverText;
    @FXML
    private ImageView coverImage;
    @FXML
    private Text valueText;
    @FXML
    private Label label;
    @FXML
    private Pane pane;
    SoundController soundc = new SoundController();

    @FXML
    public void initialize() throws FileNotFoundException {
        coverText.setText("The image under " + GameState.gameLogic.COLOR + " cover is:");
        String selectedImage = "/bv/assets/Theme/" + GameState.gameLogic.theme + "/"
                +
                GameState.getCardImage();
        Image image = new Image(this.getClass()
                .getResource(selectedImage)
                .toExternalForm());
        coverImage.setImage(image);
        coverImage.setFitWidth(150);
        coverImage.setFitHeight(150);
        valueText.setText(GameState.getAnswer());
    }

    public void closePopUp(ActionEvent event) throws IOException {
        soundc.click();
        Stage mystage = (Stage) pane.getScene().getWindow();
        mystage.close();
        GameSceneController bgc = GameSceneController.getInstance();
        if (GameState.isOnline) {
            GameState.client.closePopUp("wrong");
        } else {
            GameState.Players.changeTurn();
            bgc.createRollDiceBtn();
            bgc.setTurn(GameState.Players.checkIsPlayer1Turn());
        }
    }
}
