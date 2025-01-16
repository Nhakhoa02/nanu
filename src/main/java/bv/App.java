package bv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/bv/HomeScreen.fxml"));
        System.out.println("Starting...");

        scene = new Scene(root, 1024, 600);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.setTitle("Nanu");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}