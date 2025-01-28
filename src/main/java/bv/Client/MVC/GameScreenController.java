package bv.Client.MVC;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import bv.Client.Model.GameState;

public class GameScreenController {

    @FXML
    private GridPane pictureGrid; // Grid to display pictures

    @FXML
    private HBox playerBox; // HBox to hold player info

    @FXML
    private Label turnIndicator;

    @FXML
    private Button endTurnButton;

    @FXML
    private Button revealPictureButton;

    @FXML
    private ListView<String> leaderboardList;

    @FXML
    private Button menuSettingsButton;

    // Initialize the screen with dynamic player count
    @FXML
    public void initialize() {
        // Dynamically set the number of players based on GameState.numPlayers
        int numPlayers = GameState.getNumPlayers();

        // Clear previous player boxes if any
        playerBox.getChildren().clear();

        // Add player avatars and names at the bottom edge
        for (int i = 0; i < numPlayers; i++) {
            VBox playerVBox = new VBox(5);
            ImageView avatar = new ImageView(new Image("bv/assets/image/playerAvatar.png"));
            avatar.setFitHeight(50);
            avatar.setFitWidth(50);
            Label playerName = new Label("Player " + (i + 1));

            playerVBox.getChildren().addAll(avatar, playerName);
            playerBox.getChildren().add(playerVBox); // Add player box to the player section
        }

        // Set up the picture grid
        loadPictureGrid();

        // Set the initial turn indicator
        turnIndicator.setText("Player 1's Turn");

        // Populate the leaderboard (example data)
        loadLeaderboard();
    }

    private void loadPictureGrid() {
        int rows = 4;
        int columns = 6;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                ImageView picture = new ImageView(new Image("bv/assets/image/playerAvatar.png"));
                picture.setFitHeight(50);
                picture.setFitWidth(50);
                pictureGrid.add(picture, col, row);
            }
        }
    }

    private void loadLeaderboard() {
        leaderboardList.getItems().addAll(
            "Player 1: 5 points",
            "Player 2: 3 points",
            "Player 3: 2 points"
        );
    }

    @FXML
    private void endTurn() {
        // Logic to end the turn
        System.out.println("End Turn clicked!");
    }

    @FXML
    private void revealPicture() {
        // Logic to reveal a picture
        System.out.println("Reveal Picture clicked!");
    }

    @FXML
    private void openSettingsMenu() {
        // Logic to open settings menu
        System.out.println("Settings menu opened!");
    }
}
