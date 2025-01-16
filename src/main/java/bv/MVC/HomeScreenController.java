package bv.MVC;

import bv.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeScreenController {

    @FXML
    private Button startGameButton;

    @FXML
    private Button exitButton;

    @FXML
    private void startGame() {
        System.out.println("Start Game button clicked!");
        // Add logic to navigate to the game screen or initialize the game
        try {
            App.setRoot("GameSettings");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitApp() {
        System.out.println("Exit button clicked!");
        // Close the application
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
