package bv.Client.MVC;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import bv.Client.Client;
import bv.Client.Model.GameState;
import bv.Client.Model.Player;
import bv.Middleware.API.Type;

//Define class
/**
 * This class is responsible for managing the data of the players at the online
 * game.
 * 
 * It tells the user whether the connection of the online game is successful or
 * whether the connection has failed.
 * 
 * This class also manages the data of the players like IP-Adress, name and age.
 */
public class EnterProfileOnlController {
    private static EnterProfileOnlController epoc;

    private EnterProfileOnlController() {
    }

    @FXML
    private Text status;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField IPserver;
    @FXML
    private Button okButton;
    @FXML
    private AnchorPane pane;
    SoundController soundc = new SoundController();

    // method for instance
    public static EnterProfileOnlController getInstance() {
        if (epoc == null) {
            epoc = new EnterProfileOnlController();
        }
        return epoc;
    }

    public void statusSuccess() {
        status.setText("Connect successfully! Please wait player 2 enter the game!");
    }

    public void statusFail() {
        status.setText("Connect fail!");
    }

    public void returnBtn(ActionEvent event) throws IOException {
        soundc.click();
        if (GameState.client != null) {
            GameState.client.close();
        }
        SceneController sc = SceneController.getInstance();
        sc.chooseRole(event);
    }

    public void enterOnlineGame(ActionEvent event) throws IOException, InterruptedException {
        soundc.click();
        String name = nameTF.getText();
        String age = ageTF.getText();
        String ipv4 = IPserver.getText();
        if (!GameState.Players.validateValue(name, age))
            return;
        GameState.Players.PLAYER1 = new Player(name, Integer.parseInt(age));
        try {
            GameState.client = new Client(ipv4);
        } catch (Exception e) {
            SceneController sc = SceneController.getInstance();
            sc.showAlertMessage(AlertType.ERROR, "Connection Failure", "IPv4 Address of the server not found!!");
            statusFail();
            return;
            // TODO: handle exception
        }
        GameState.isOnline = true;
        GameState.client.listenForMessage();
        GameState.client.sendMessage(GameState.Players.PLAYER1.getAge() + "", Type.ENTER_PROFILE);
        pane.getChildren().remove(okButton);
    }
}
