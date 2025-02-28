package bv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import bv.Client.Model.GameState;

import java.io.IOException;

/**
 * The App class extends the javafx.application.Application class and serves as
 * the main class for the application.
 * 
 * It sets up the primary stage and scene of the application using JavaFX FXML,
 * loads the HomeScreen.fxml file, and sets the stage's title to "Nanu".
 * 
 * It also sets the stage in the GameState class for further use.
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/HomeScreen.fxml"));
        System.out.println("Starting...");

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Nanu");
        GameState.stage = stage;
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}