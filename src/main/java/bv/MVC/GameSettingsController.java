package bv.MVC;

import bv.App;
import bv.Model.GameState;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import bv.Model.GameState;

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

        // Validate timePerGuessTextField input
        String timeText = timePerGuessTextField.getText();
        int timePerGuess;

        try {
            // Attempt to parse the input
            timePerGuess = Integer.parseInt(timeText);

            // Check if the parsed value is positive
            if (timePerGuess <= 0) {
                throw new NumberFormatException("Time must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            // Show an alert if input is invalid
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Time Per Guess Error");
            alert.setContentText("Please enter a valid positive number for time per guess.");
            alert.showAndWait();
            return; // Stop execution if input is invalid
        }

        // Extracting values from the UI components
        int lidCount = lidCountChoiceBox.getValue();
        int playerCount = playerCountChoiceBox.getValue();
        timePerGuess = Integer.parseInt(timePerGuessTextField.getText()); // Converting string input to integer
        String topic = topicChoiceBox.getValue();

        // Updating GameState Model with the extracted values
        GameState.setGameState(lidCount, playerCount, timePerGuess, topic);
        // Debugging: Print the extracted values and verify the GameState object
        System.out.println("Play Offline clicked!");
        System.out.println("Lid Count: " + GameState.getNumLids());
        System.out.println("Player Count: " + GameState.getNumPlayers());
        System.out.println("Time Per Guess: " + GameState.getNumTimePerGuess());
        System.out.println("Topic: " + GameState.getTopic());

        try {
            App.setRoot("GameScreen");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
