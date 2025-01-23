package bv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * 
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        // Load the HomeScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/HomeScreen.fxml"));
        System.out.println("Starting...");


        // Create a new scene 1024 wide 600 height
        scene = new Scene(root, 1024, 600);

        // Add the CSS file to the scene
        scene.getStylesheets().add(getClass().getResource("/bv/assets/style/style.css").toExternalForm());
       
        // Set the scene can be resized
        stage.setResizable(true);

        // Apply these effects
        stage.setScene(scene);
        stage.setTitle("Nanu");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        // Change the root of the scene dynamically
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/bv/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}