package bv.MVC;

import bv.App;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class GameSettingsController {

    @FXML
    private ChoiceBox<Integer> playerCountChoiceBox;

    @FXML
    private ChoiceBox<Integer> lidCountChoiceBox;

    @FXML
    private ChoiceBox<String> topicChoiceBox;

    @FXML
    private TextField timePerGuessTextField;

    @FXML
    private void initialize() {
        // Initialize player player count options
        playerCountChoiceBox.setItems(FXCollections.observableArrayList(2, 3, 4, 5));
        playerCountChoiceBox.setValue(2); // Default value

        // Initialize player lid count options
        lidCountChoiceBox.setItems(FXCollections.observableArrayList(2, 3, 4, 5));
        lidCountChoiceBox.setValue(2); // Default value

        // Initialize topics
        topicChoiceBox.setItems(FXCollections.observableArrayList("Topic 1", "Topic 2"));
        topicChoiceBox.setValue("Topic 1"); // Default value
    }

    @FXML
    private void playOnline() {
        System.out.println("Play Online clicked!");
    }

    @FXML
    private void playOffline() {
        System.out.println("Play Offline clicked!");
    }

    @FXML
    private void cancel() {
        System.out.println("Cancel clicked!");
        try {
            App.setRoot("HomeScreen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
